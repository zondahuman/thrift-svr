package com.abin.lee.thrift.service.dao;

import com.abin.lee.thrift.model.Book;
import com.abin.lee.thrift.model.Contact;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ContactManagerDao {

	private static Logger logger = Logger.getLogger(ContactManagerDao.class);
	public void save(Contact contact) {
		// TODO Auto-generated method stub
		logger.info("ContactManagerDao save run");
	}

	
	public void remove(int id)  {
		// TODO Auto-generated method stub
		logger.info("ContactManagerDao remove run");
	}

	
	public List<Contact> getAll()  {
		// TODO Auto-generated method stub
		logger.info("ContactManagerDao getAll run");
		List<Contact> list = new ArrayList<Contact>();
		Book book = new Book();
		book.setId(10);
		book.setName("西游记");
		Book book2 = new Book();
		book2.setId(11);
		book2.setName("水浒传");
		Contact contract = new Contact();
		contract.setBirthday(100000000);
		contract.setId(101);
		contract.setIpAddress("192.168.0.101");
		contract.setName("超人");
		contract.setPhoneNo("13312345678");
		contract.setSalary(98456.36);
		Set<Book> set = new HashSet<Book>();
		set.add(book);
		set.add(book2);
		contract.setBooks(set);
		list.add(contract);
		logger.info(list.toString());
		return list;
	}

	
	public List<Contact> query(Map<String, String> conditions)
			 {
		// TODO Auto-generated method stub
		logger.info("ContactManagerDao query run");
		logger.info(conditions.toString());
		List<Contact> list = new ArrayList<Contact>();
		Contact contract = new Contact();
		contract.setBirthday(100000000);
		contract.setId(101);
		contract.setIpAddress("192.168.0.101");
		contract.setName("超人");
		contract.setPhoneNo("13312345678");
		contract.setSalary(98456.36);
		list.add(contract);
		
		Contact contract2 = new Contact();
		contract2.setBirthday(200000000);
		contract2.setId(101);
		contract2.setIpAddress("192.168.0.102");
		contract2.setName("超人2");
		contract2.setPhoneNo("13312345672");
		contract2.setSalary(98456.32);
		list.add(contract2);
		return list;
	}
}
