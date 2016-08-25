package com.abin.lee.thrift.service.impl;

import com.abin.lee.thrift.model.Contact;
import com.abin.lee.thrift.service.dao.ContactManagerDao;
import com.abin.lee.thrift.service.interfacei.contract.Iface;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ContactManagerImpl implements Iface {
	@Autowired
	private ContactManagerDao dao;

	@Override
	public void save(Contact contact) throws TException {
		// TODO Auto-generated method stub
		dao.save(contact);
	}

	@Override
	public void remove(int id) throws TException {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public List<Contact> getAll() throws TException {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public List<Contact> query(Map<String, String> conditions)
			throws TException {
		// TODO Auto-generated method stub
		return dao.query(conditions);
	}

}
