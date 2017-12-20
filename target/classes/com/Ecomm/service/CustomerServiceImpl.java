package com.Ecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecomm.dao.CustomerDAOImpl;

import com.Ecomm.mymodel.Customers;


@Service
public class CustomerServiceImpl {
	@Autowired
	private CustomerDAOImpl cust;
	public void addCustomer(Customers p) {
	
		cust.addCustomer(p);
		
	}
	public Customers getCustomerById(int id) {
		return cust.getCustomerById(id);
	}

}
