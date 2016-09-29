package com.abin.lee.thrift.common.support.impl;


import com.abin.lee.thrift.common.support.ThriftServerAddressProvider;

import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * User: guanqing-liu
 * Date: 13-12-12
 * Time: 上午11:01
 */
public class FixedAddressProvider implements ThriftServerAddressProvider {

    private final List<InetSocketAddress> container = new CopyOnWriteArrayList<InetSocketAddress>();

    private Queue<InetSocketAddress> inner = new LinkedList<InetSocketAddress>();

    public FixedAddressProvider(){}

    public FixedAddressProvider(String serverAddress){
        String[] hostnames = serverAddress.split(";");//"ip:port:priority;ip:port"
        for (String hostname : hostnames) {
            String[] address = hostname.split(":");
            InetSocketAddress sa = new InetSocketAddress(address[0],Integer.valueOf(address[1]));
            //根据权重值
            Integer priority = 1;//权重值
            if(address.length == 3){
                priority = Integer.valueOf(address[2]);
            }
            //权重越高,list中占有的数据条目越多
            for(int i=0; i< priority; i++){
                container.add(sa);
            }
        }
        //随机
        Collections.shuffle(container);
        inner.addAll(container);
    }

    @Override
    public List<InetSocketAddress> getAll() {
        return Collections.unmodifiableList(container);
    }

    @Override
    public synchronized  InetSocketAddress selector() {
        if(inner.isEmpty()){
            inner.addAll(container);
        }
        return inner.poll();
    }

    @Override
    public void close() {
    }
}
