package com.Ecomm.dao;

import java.io.Serializable;
import java.security.Principal;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Ecomm.mymodel.Customers;
import com.Ecomm.mymodel.ShippingAddress;

@Repository
public class ShippingDAO implements Serializable {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addShippingAddress(ShippingAddress add, Principal p)
	{
	  Session	session =sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  
	  Query query = session.createQuery("from Customers where username = ?");
      query.setString(0, p.getName());

      Customers c= (Customers) query.uniqueResult();
     
      c.setShippingAddress(add);
      add.setUsersDetail(c);
      session.save(add);
      session.update(c);
      tx.commit();
      session.close();

	}

}
