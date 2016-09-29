package com.abin.lee.thrift.service.proxy;

import com.abin.lee.thrift.common.support.ThriftServerAddressReporter;
import com.abin.lee.thrift.common.support.ThriftServerIpTransfer;
import com.abin.lee.thrift.common.support.impl.LocalNetworkIpTransfer;
import com.abin.lee.thrift.service.UserService.Processor;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.springframework.beans.factory.InitializingBean;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Constructor;

public class ThriftServiceServerFactory implements InitializingBean {

	private Integer port;

	private Integer priority = 1;// default

	private Object service;// serice实现类

	private ThriftServerIpTransfer ipTransfer;

	private ThriftServerAddressReporter addressReporter;
	
	private ServerThread serverThread;
	
	private String configPath;

	public void setService(Object service) {
		this.service = service;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public void setIpTransfer(ThriftServerIpTransfer ipTransfer) {
		this.ipTransfer = ipTransfer;
	}

	public void setAddressReporter(ThriftServerAddressReporter addressReporter) {
		this.addressReporter = addressReporter;
	}
	

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (ipTransfer == null) {
			ipTransfer = new LocalNetworkIpTransfer();
		}
		String ip = ipTransfer.getIp();
		if (ip == null) {
			throw new NullPointerException("cant find server ip...");
		}
		String hostname = ip + ":" + port + ":" + priority;
		Class serviceClass = service.getClass();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Class<?>[] interfaces = serviceClass.getInterfaces();
		if (interfaces.length == 0) {
			throw new IllegalClassFormatException("service-class should implements Iface");
		}

		// reflect,load "Processor";
		Processor processor = null;
		for (Class clazz : interfaces) {
			String cname = clazz.getSimpleName();
			if (!cname.equals("Iface")) {
				continue;
			}
			String pname = clazz.getEnclosingClass().getName() + "$Processor";
			try {
				Class pclass = classLoader.loadClass(pname);
				if (!pclass.isAssignableFrom(Processor.class)) {
					continue;
				}
				Constructor constructor = pclass.getConstructor(clazz);
				processor = (Processor) constructor.newInstance(service);
				break;
			} catch (Exception e) {
				//
			}
		}

		if (processor == null) {
			throw new IllegalClassFormatException("service-class should implements Iface");
		}
		//需要单独的线程,因为serve方法是阻塞的.
		serverThread = new ServerThread(processor, port);
		serverThread.start();
		// report
		if (addressReporter != null) {
			addressReporter.report(configPath, hostname);
		}

	}

	class ServerThread extends Thread {
		private TServer server;

		ServerThread(Processor processor, int port) throws Exception {
			TServerSocket serverTransport = new TServerSocket(port);
			Factory portFactory = new Factory(true, true);
			Args args = new Args(serverTransport);
			args.processor(processor);
			args.protocolFactory(portFactory);
			server = new TThreadPoolServer(args);
		}

		@Override
		public void run(){
			try{
				server.serve();
			}catch(Exception e){
				//
			}
		}
		
		public void stopServer(){
			server.stop();
		}
	}

	public void close() {
		serverThread.stopServer();
	}

}
