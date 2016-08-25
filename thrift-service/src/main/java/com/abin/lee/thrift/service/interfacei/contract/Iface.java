package com.abin.lee.thrift.service.interfacei.contract;


import com.abin.lee.thrift.model.Contact;

import java.util.List;
import java.util.Map;

public interface Iface {

    public void save(Contact contact) throws org.apache.thrift.TException;

    public void remove(int id) throws org.apache.thrift.TException;

    public List<Contact> getAll() throws org.apache.thrift.TException;

    public List<Contact> query(Map<String, String> conditions) throws org.apache.thrift.TException;

  }

