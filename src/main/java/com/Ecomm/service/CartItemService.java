package com.Ecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecomm.mymodel.Cart;
import com.Ecomm.mymodel.CartItem;
import com.Ecomm.dao.CartItemDAO;


@Service
public class CartItemService {
	   @Autowired
	    private CartItemDAO cartItemDao;

	    public void addCartItem(CartItem cartItem) {
	        cartItemDao.addCartItem(cartItem);
	    }

	    public void removeCartItem(CartItem cartItem) {
	        cartItemDao.removeCartItem(cartItem);
	    }

	    public void removeAllCartItems(Cart cart){
	        cartItemDao.removeAllCartItems(cart);
	    }

	    public CartItem getCartItemByItemId (int itemId) {
	        return cartItemDao.getCartItemByItemId(itemId);
	    }

}
