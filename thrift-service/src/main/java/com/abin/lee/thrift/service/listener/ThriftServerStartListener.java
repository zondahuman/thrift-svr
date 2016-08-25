package com.abin.lee.thrift.service.listener;

import com.abin.lee.thrift.service.impl.UserServiceImpl;
import com.abin.lee.thrift.service.proxy.ThriftServerProxy;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class ThriftServerStartListener implements ServletContextListener{
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void contextInitialized(ServletContextEvent event) {
		//启动SETUP SEERVER
		try {
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
			
			List<ThriftServerProxy> list = ((List<ThriftServerProxy>) context.getBean("thriftServerList"));
			if(list!=null&&list.size()>0){
				for(ThriftServerProxy userProxy:list){
					userProxy.start();
				}
			}

			logger.info("Thrift Server监听接口启动。。。。。。。。。。。");
		} catch (Exception e) {
			logger.error("Thrift Server监听接口启动错误", e);
			e.printStackTrace();
		}
	}

}
