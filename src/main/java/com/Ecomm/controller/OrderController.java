package com.Ecomm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ecomm.mymodel.Cart;
import com.Ecomm.mymodel.Customers;
import com.Ecomm.mymodel.CustomerOrder;
import com.Ecomm.service.CartService;
import com.Ecomm.service.OrderService;



@Controller
public class OrderController {
	  @Autowired
	    private CartService cartService;

	    @Autowired
	    private OrderService orderService;
	    
	    /* * createOrder method is used to insert user order into the database.*/
	     
	    @RequestMapping("/order/{cartId}")
	    public String createOrder(@PathVariable("cartId") int cartId) {
	    	CustomerOrder userOrder = new CustomerOrder();
	        Cart cart=cartService.getCartById(cartId);
	        userOrder.setCart(cart);

	        Customers usersDetail = cart.getUsersDetail();
	        userOrder.setUsersDetail(usersDetail);
	  //      userOrder.setShippingAddress();

	        orderService.addOrder(userOrder);

	        return "redirect:/checkout?cartId="+cartId;
	    }

}
