package com.abin.lee.thrift.service.impl;

import com.abin.lee.thrift.service.PythonService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service
public class PythonServiceImpl implements PythonService.Iface{

	@Override
	public String get(int id) throws TException {
		// TODO Auto-generated method stub
		return "get=="+id;
	}

	@Override
	public int remove(int id) throws TException {
		// TODO Auto-generated method stub
		return 100+id;
	}

}
