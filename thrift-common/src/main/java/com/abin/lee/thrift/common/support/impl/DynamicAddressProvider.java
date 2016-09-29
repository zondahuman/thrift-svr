package com.abin.lee.thrift.common.support.impl;

import com.abin.lee.thrift.common.support.ThriftServerAddressProvider;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.springframework.beans.factory.InitializingBean;

import java.net.InetSocketAddress;
import java.util.*;

/**
 * 可以动态获取address地址,方案设计参考
 * 1) 可以间歇性的调用一个web-service来获取地址
 * 2) 可以使用事件监听机制,被动的接收消息,来获取最新的地址(比如基于MQ,nio等)
 * 3) 可以基于zookeeper-watcher机制,获取最新地址
 * <p/>
 * 本实例,使用zookeeper作为"config"中心,使用apache-curator方法库来简化zookeeper开发
 * 如下实现,仅供参考
 */
public class DynamicAddressProvider implements ThriftServerAddressProvider, InitializingBean {

    private String configPath;

    private PathChildrenCache cachedPath;

    private CuratorFramework zookeeper;
    
    //用来保存当前provider所接触过的地址记录
    //当zookeeper集群故障时,可以使用trace中地址,作为"备份"
    private Set<String> trace = new HashSet<String>();

    private final List<InetSocketAddress> container = new ArrayList<InetSocketAddress>();

    private Queue<InetSocketAddress> inner = new LinkedList<InetSocketAddress>();
    
    private Object lock = new Object();
    
    private static final Integer DEFAULT_PRIORITY = 1;

    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }

    public void setZookeeper(CuratorFramework zookeeper) {
        this.zookeeper = zookeeper;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    	//如果zk尚未启动,则启动
    	if(zookeeper.getState() == CuratorFrameworkState.LATENT){
    		zookeeper.start();
    	}
        buildPathChildrenCache(zookeeper, configPath, true);
        cachedPath.start(StartMode.POST_INITIALIZED_EVENT);
    }

    private void buildPathChildrenCache(CuratorFramework client, String path, Boolean cacheData) throws Exception {
        cachedPath = new PathChildrenCache(client, path, cacheData);
        cachedPath.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                PathChildrenCacheEvent.Type eventType = event.getType();
                switch (eventType) {
//                    case CONNECTION_RECONNECTED:
//                        
//                        break;
                    case CONNECTION_SUSPENDED:
                    case CONNECTION_LOST:
                        System.out.println("Connection error,waiting...");
                        return;
                    default:
                        //
                }
                //任何节点的时机数据变动,都会rebuild,此处为一个"简单的"做法.
                cachedPath.rebuild();
                rebuild();
            }
            
            protected void rebuild() throws Exception {
                List<ChildData> children = cachedPath.getCurrentData();
                if (children == null || children.isEmpty()) {
                    //有可能所有的thrift server都与zookeeper断开了链接
                    //但是,有可能,thrift client与thrift server之间的网络是良好的
                    //因此此处是否需要清空container,是需要多方面考虑的.
                    container.clear();
                    System.out.println("thrift server-cluster error....");
                    return;
                }
                List<InetSocketAddress> current = new ArrayList<InetSocketAddress>();
                for (ChildData data : children) {
                    String address = new String(data.getData(), "utf-8");
                    current.addAll(transfer(address));
                    trace.add(address);
                }
                Collections.shuffle(current);
                synchronized (lock) {
                    container.clear();
                    container.addAll(current);
                    inner.clear();
                    inner.addAll(current);
        			
        		}
            }
        });
    }
    
    
    
    private List<InetSocketAddress> transfer(String address){
    	String[] hostname = address.split(":");
    	Integer priority = DEFAULT_PRIORITY;
        if (hostname.length == 3) {
            priority = Integer.valueOf(hostname[2]);
        }
        String ip = hostname[0];
        Integer port = Integer.valueOf(hostname[1]);
        List<InetSocketAddress> result = new ArrayList<InetSocketAddress>();
        for (int i = 0; i < priority; i++) {
        	result.add(new InetSocketAddress(ip, port));
        }
        return result;
    }


    @Override
    public List<InetSocketAddress> getAll() {
        return Collections.unmodifiableList(container);
    }

    @Override
    public synchronized InetSocketAddress selector() {
        if (inner.isEmpty()) {
        	if(!container.isEmpty()){
        		inner.addAll(container);
        	}else if(!trace.isEmpty()){
        		synchronized (lock) {
        			for(String hostname : trace){
        				container.addAll(transfer(hostname));
        			}
        			Collections.shuffle(container);
        			inner.addAll(container);
				}
        	}
        }
        return inner.poll();//null
    }


    @Override
    public void close() {
        try {
            cachedPath.close();
            zookeeper.close();
        } catch (Exception e) {
            //
        }
    }
}
