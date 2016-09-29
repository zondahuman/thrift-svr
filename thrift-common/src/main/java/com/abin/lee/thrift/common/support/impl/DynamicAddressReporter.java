package com.abin.lee.thrift.common.support.impl;

import com.abin.lee.thrift.common.support.ThriftServerAddressReporter;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.zookeeper.CreateMode;

public class DynamicAddressReporter implements ThriftServerAddressReporter {
	
	private CuratorFramework zookeeper;
	
	public DynamicAddressReporter(){}
	
	public DynamicAddressReporter(CuratorFramework zookeeper){
		this.zookeeper = zookeeper;
	}


	public void setZookeeper(CuratorFramework zookeeper) {
		this.zookeeper = zookeeper;
	}

	@Override
	public void report(String service, String address) throws Exception {
		if(zookeeper.getState() == CuratorFrameworkState.LATENT){
			zookeeper.start();
			zookeeper.newNamespaceAwareEnsurePath(service);
		}
		zookeeper.create()
			.creatingParentsIfNeeded()
			.withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
			.forPath(service +"/i_", address.getBytes("utf-8"));
	}
	
	
	public void close(){
		zookeeper.close();
	}

}
