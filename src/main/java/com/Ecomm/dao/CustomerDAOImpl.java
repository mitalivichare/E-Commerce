package com.Ecomm.dao;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Ecomm.mymodel.Cart;
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
		Cart c = new Cart();
		c.setGrandTotal(0);
		c.setUsersDetail(p);
		session.save(c);
		p.setCart(c);
		session.update(p);
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
	public List<Customers> getAllUsers() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Customers");
        @SuppressWarnings("unchecked")
		List<Customers> usersDetail = query.list();
        session.close();
        return usersDetail;
    }

    public Customers getUserByUsername (String username) {
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("from Customers where username = ?");
        query.setString(0, username);
        session.close();
        return (Customers) query.uniqueResult();
    }



}
