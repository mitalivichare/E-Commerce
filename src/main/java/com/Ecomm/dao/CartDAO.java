package com.Ecomm.dao;

import java.io.IOException;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Ecomm.mymodel.Cart;

import com.Ecomm.service.OrderService;



@Repository
public class CartDAO {
	 @Autowired
	    private SessionFactory sessionFactory;

	    @Autowired
	    private OrderService orderService;
	    
	    
	    public Cart getCartById (int cartId) {
	        Session session = sessionFactory.openSession();
	        
	        return (Cart) session.get(Cart.class, cartId);
	    }
	   
	    
	    public void update(Cart cart) {
	        int cartId = cart.getCartId();
	        double grandTotal = orderService.getOrderGrandTotal(cartId);
	        cart.setGrandTotal(grandTotal);

	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.saveOrUpdate(cart);
	        tx.commit();
	        session.close();
	        
	    }
	

	    public Cart validate(int cartId) throws IOException {
	        Cart cart=getCartById(cartId);
	        if(cart==null||cart.getCartItems().size()==0) {
	            throw new IOException(cartId+"");
	        }
	        update(cart);
	        return cart;
	    }

}
