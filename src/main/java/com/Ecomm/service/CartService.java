package com.Ecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecomm.dao.CartDAO;
import com.Ecomm.mymodel.Cart;


@Service
public class CartService {
	  @Autowired
	    private CartDAO cartDao;

	    public Cart getCartById(int cartId) {
	        return cartDao.getCartById(cartId);
	    }

	    public void update(Cart cart) {
	        cartDao.update(cart);
	    }

}
