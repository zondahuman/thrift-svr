package com.abin.lee.thrift.common.support;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * thrift server-service地址提供者,用来想连接池中输出socket
 */
public interface ThriftServerAddressProvider {

    public List<InetSocketAddress> getAll();

    /**
     * 选取一个合适的address,可以随机获取等'
     * 内部可以使用合适的算法.
     * @return
     */
    public InetSocketAddress selector();

    public void close();


}
