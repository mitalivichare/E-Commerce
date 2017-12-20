package com.Ecomm.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Ecomm.mymodel.CustomerOrder;



@Repository
public class OrderDAO implements Serializable {
	 @Autowired
     private SessionFactory sessionFactory;
@Transactional
     public void addOrder(CustomerOrder userOrder) {
         Session session = sessionFactory.openSession();
     	Transaction tx = session.beginTransaction();
         session.saveOrUpdate(userOrder);
         tx.commit();
         session.flush();
         session.close();
     }

}
