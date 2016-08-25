package com.abin.lee.thrift.service.servlet;

import com.abin.lee.thrift.service.ContactManager;
import com.abin.lee.thrift.service.impl.ContactManagerImpl;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServlet;

@SuppressWarnings("serial")
public class ContractManageServlet extends TServlet {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ContractManageServlet(ContactManagerImpl contractManage) {
		super(new ContactManager.Processor(contractManage),
				new TCompactProtocol.Factory());
	}

	
	
}
