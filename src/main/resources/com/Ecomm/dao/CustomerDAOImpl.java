package com.Ecomm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Ecomm.mymodel.Customers;
import com.Ecomm.mymodel.UserRoles;


@Repository
public class CustomerDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public void addCustomer(Customers p) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		UserRoles ur = new UserRoles();
		ur.setAuthority("ROLE_USER");
		ur.setCustId(p.getCustId());
		session.save(ur);
		tx.commit();
		session.close();
	}
	public Customers getCustomerById(int id) {
		Session session = sessionFactory.openSession();		
//		System.out.print(id);
		Customers p = (Customers) session.load(Customers.class, new Integer(id));
		session.close();
		return p;
	}

}
