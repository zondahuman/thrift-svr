package com.abin.lee.thrift.service.proxy;

import com.abin.lee.thrift.service.listener.ThriftServerStartListener;
import org.apache.log4j.Logger;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;

public class ThriftServerProxy {
	
	
	private static Logger logger = Logger.getLogger(ThriftServerStartListener.class);
	private int port;// 端口
	private String serviceInterface;// 实现类接口
	
	private Object serviceImplObject;//实现类
	
	private String serviceIface;//接口

	public Object getServiceImplObject() {
		return serviceImplObject;
	}

	public void setServiceImplObject(Object serviceImplObject) {
		this.serviceImplObject = serviceImplObject;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	

	public String getServiceInterface() {
		return serviceInterface;
	}

	public void setServiceInterface(String serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	
	public String getServiceIface() {
		return serviceIface;
	}

	public void setServiceIface(String serviceIface) {
		this.serviceIface = serviceIface;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void start() {
		new Thread() {
			public void run() {

				try {
					TServerSocket serverTransport = new TServerSocket(getPort());					
					Class Processor = Class.forName(getServiceInterface()+"$Processor");
					Class Iface = Class.forName(StringUtils.hasText(getServiceIface())?getServiceIface():getServiceInterface()+"$Iface");
					
					
					Constructor con = Processor.getConstructor(Iface);
					TProcessor processor = (TProcessor)con.newInstance(serviceImplObject);

//					TProtocolFactory protFactory = new TBinaryProtocol.Factory(true,true);
					TProtocolFactory protFactory = new TCompactProtocol.Factory(1024);
					TThreadPoolServer.Args args = new TThreadPoolServer.Args(
							serverTransport);
					args.protocolFactory(protFactory);
					
					args.processor(processor);
					TServer server = new TThreadPoolServer(args);
					logger.info("Starting server on port "+getPort()+" ...");
					server.serve();

				} catch (TTransportException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	
		

}
