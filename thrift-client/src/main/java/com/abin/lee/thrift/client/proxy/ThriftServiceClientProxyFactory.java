package com.abin.lee.thrift.client.proxy;

import com.abin.lee.thrift.common.proxy.ThriftClientPoolFactory;
import com.abin.lee.thrift.common.support.ThriftServerAddressProvider;
import com.abin.lee.thrift.common.support.impl.FixedAddressProvider;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.TServiceClientFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: guanqing-liu
 * Date: 13-12-13
 * Time: 下午6:17
 * To change this template use File | Settings | File Templates.
 */

@SuppressWarnings("rawtypes")
public class ThriftServiceClientProxyFactory implements FactoryBean, InitializingBean {

    private String service;

    private String serverAddress;

    private Integer maxActive = 32;//最大活跃连接数

    ////ms,default 3 min,链接空闲时间
    //-1,关闭空闲检测
    private Integer idleTime = 180000;
    private ThriftServerAddressProvider addressProvider;

    private Object proxyClient;


    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }


    public void setIdleTime(Integer idleTime) {
        this.idleTime = idleTime;
    }


    public void setService(String service) {
        this.service = service;
    }


    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }


    public void setAddressProvider(ThriftServerAddressProvider addressProvider) {
        this.addressProvider = addressProvider;
    }

    private Class objectClass;

    private GenericObjectPool<TServiceClient> pool;

    private ThriftClientPoolFactory.PoolOperationCallBack callback = new ThriftClientPoolFactory.PoolOperationCallBack() {

        @Override
        public void make(TServiceClient client) {
            System.out.println("create");

        }

        @Override
        public void destroy(TServiceClient client) {
            System.out.println("destroy");

        }
    };

    @Override
    public void afterPropertiesSet() throws Exception {
        if (serverAddress != null) {
            addressProvider = new FixedAddressProvider(serverAddress);
        }
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //加载Iface接口
        objectClass = classLoader.loadClass(service + "$Iface");
        //加载Client.Factory类
        Class<TServiceClientFactory<TServiceClient>> fi = (Class<TServiceClientFactory<TServiceClient>>) classLoader.loadClass(service + "$Client$Factory");
        TServiceClientFactory<TServiceClient> clientFactory = fi.newInstance();
        ThriftClientPoolFactory clientPool = new ThriftClientPoolFactory(addressProvider, clientFactory, callback);
        GenericObjectPool.Config poolConfig = new GenericObjectPool.Config();
        poolConfig.maxActive = maxActive;
        poolConfig.minIdle = 0;
        poolConfig.minEvictableIdleTimeMillis = idleTime;
        poolConfig.timeBetweenEvictionRunsMillis = idleTime / 2L;
        pool = new GenericObjectPool<TServiceClient>(clientPool, poolConfig);
        proxyClient = Proxy.newProxyInstance(classLoader, new Class[]{objectClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //
                TServiceClient client = pool.borrowObject();
                try {
                    return method.invoke(client, args);
                } catch (Exception e) {
                    throw e;
                } finally {
                    pool.returnObject(client);
                }
            }
        });
    }

    @Override
    public Object getObject() throws Exception {
        return proxyClient;
    }

    @Override
    public Class<?> getObjectType() {
        return objectClass;
    }

    @Override
    public boolean isSingleton() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void close() {
        if (addressProvider != null) {
            addressProvider.close();
        }
    }
}
