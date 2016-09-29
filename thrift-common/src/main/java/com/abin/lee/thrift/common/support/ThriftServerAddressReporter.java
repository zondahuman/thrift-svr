package com.abin.lee.thrift.common.support;

/**
 * 
 *
 * 向远端或者任何侦听者,发送当前server service的address以及其他信息
 * 比如向zookeeper中发送当前sercie地址.
 */
public interface ThriftServerAddressReporter {

	
	public void report(String service, String address) throws Exception;
}
