package com.abin.lee.thrift.common.support;

/**
 * 
 *
 * thrift-server端如何获取当前server的ip信息
 * 1) 可以从一个物理机器或者虚机的特殊文件中解析
 * 2) 可以获取指定网卡序号的Ip
 * 3) 其他
 * 本实例,就直接从可用的一个网卡中获取IP
 */
public interface ThriftServerIpTransfer {
	
	public String getIp() throws Exception;
	
	public void reset();
	
	//当IP变更时,将会调用reset方法
	static interface IpRestCalllBack{
		
		public void rest(String newIp);
	}

}
