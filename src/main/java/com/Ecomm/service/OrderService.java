package com.Ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecomm.dao.OrderDAO;
import com.Ecomm.mymodel.Cart;
import com.Ecomm.mymodel.CartItem;
import com.Ecomm.mymodel.CustomerOrder;



@Service
public class OrderService {

	 @Autowired
	    private OrderDAO orderDao;

	    @Autowired
	    private CartService cartService;

	    public void addOrder(CustomerOrder userOrder) {
	    	orderDao.addOrder(userOrder);
	    }

	    public double getOrderGrandTotal(int cartId) {
	        double grandTotal=0;
	        Cart cart = cartService.getCartById(cartId);
	        List<CartItem> cartItems = cart.getCartItems();

	        for (CartItem item : cartItems) {
	            grandTotal+=item.getTotalPrice();
	        }

	        return grandTotal;
	    }

}
