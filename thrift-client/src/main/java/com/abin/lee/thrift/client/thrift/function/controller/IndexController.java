/*******************************************************************************
 * COPYRIGHT Beijing adsohu Co.,Ltd.                                      *
 *******************************************************************************
 * 源文件名: IndexController.java													       
 * 功能: 
 * 版本:	1.0	                                                                   
 * 编制日期: 2009-6-8
 * 说明:
 * 修改历史: (主要历史变动原因及说明)					      
 * YYMMDD      |     Author    |    Change Description 
 * 2009-6-8    Liujiajun         Created
 *******************************************************************************/
package com.abin.lee.thrift.client.thrift.function.controller;


import java.util.List;

import javax.annotation.Resource;

import com.abin.lee.thrift.client.interfacei.contract.Iface;
import com.abin.lee.thrift.client.thrift.proxy.ThriftClientProxy;
import com.abin.lee.thrift.client.thrift.proxy.ThriftServletClientProxy;
import com.abin.lee.thrift.client.thrift.service.Contact;
import com.abin.lee.thrift.client.thrift.service.ContactManager;
import com.abin.lee.thrift.client.thrift.service.UserService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/thrift")
@Controller
public class IndexController {
	
	@Resource(name="userClient01")
	private ThriftClientProxy client01;
	
	
	@Resource(name="contactClient03")
	private ThriftClientProxy contactClient03;
	
	@Resource(name="contractService")
	private Iface contractService;
	
	@Resource(name="contractManage")
	private ThriftServletClientProxy contractManage;
	
	@Resource(name="userService")
	private ThriftServletClientProxy userService;

	
	/**
	 * 展示首页面
	 * 
	 * @param model
	 *            数据封装
	 * @return 首页视图
	 */
	@RequestMapping("/index.do")
	public String handleIndex(String name) {
		UserService.Client client = (UserService.Client)(client01.getClient());
		ContactManager.Client contactClient = (ContactManager.Client)(contactClient03.getClient());
		ContactManager.Client contactClientS = (ContactManager.Client)(contractManage.getClient());
				
		try {
			client.getUser("zhangsan");
			name = client.getUserName(name, 100);
			
			List<Contact> list = contactClient.getAll();
			contactClient.remove(100);
			
			List<Contact> list2 = contractService.getAll();
			
			List<Contact> list3 = contactClientS.getAll();

            System.out.println("userName: " + name);
			System.out.println("contactList : " + list);
			System.out.println("contactList2 : " +  list2);
			System.out.println("contactList3 : " +  list3);
			
			
		} catch (TException e) {
			e.printStackTrace();
            return "FAILURE";
		}
		
		return "SUCCESS";
	}
	
	

	
	
	
}
