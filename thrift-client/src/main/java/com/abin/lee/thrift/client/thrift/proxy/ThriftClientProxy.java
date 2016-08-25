package com.abin.lee.thrift.client.thrift.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.abin.lee.thrift.client.thrift.common.ConnectionManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;


public class ThriftClientProxy {

	private String serviceInterface;

	public String getServiceInterface() {
		return serviceInterface;
	}

	public void setServiceInterface(String serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	private ConnectionManager connectionManager;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object getClient() {
		Object object = null;
		try {
			TTransport transport = connectionManager.getSocket();

//			TProtocol protocol = new TBinaryProtocol(transport);
			TProtocol protocol = new TCompactProtocol(transport);
			Class client = Class.forName(getServiceInterface() + "$Client");

			Constructor con = client.getConstructor(TProtocol.class);
			object = con.newInstance(protocol);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
}
