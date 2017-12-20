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
import com.Ecomm.mymodel.CartItem;



@Repository
public class CartItemDAO {
	 @Autowired
	    private SessionFactory sessionFactory;
	 	
	 	
	    public void addCartItem(CartItem cartItem) {
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.saveOrUpdate(cartItem);
	        tx.commit();
	        session.flush();
	       
	        session.close();
	    }

	 	
	    public void removeCartItem (CartItem cartItem) {
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.delete(cartItem);
	        tx.commit();
	        session.flush();
	        /*session.close();*/
	        
	    }
	 	
	    public void removeAllCartItems(Cart cart) {
	        List<CartItem> cartItems = cart.getCartItems();

	        for (CartItem item : cartItems) {
	            removeCartItem(item);
	        }
	    }

	    public CartItem getCartItemByItemId (int itemId) {
	        Session session = sessionFactory.openSession();
	        Query query = session.createQuery("from CartItem where itemId = ?");
	        query.setInteger(0, itemId);
	        session.flush();
	        /*session.close();*/
	        return (CartItem) query.uniqueResult();
	    }

}
