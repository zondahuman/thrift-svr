package com.abin.lee.thrift.service.interfacei.user;

public interface Iface {

    public void getUser(String uid) throws org.apache.thrift.TException;

    public String getUserName(String uid, int age) throws org.apache.thrift.TException;

  }
