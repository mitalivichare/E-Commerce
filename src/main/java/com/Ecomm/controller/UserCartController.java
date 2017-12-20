package com.Ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ecomm.mymodel.Customers;
import com.Ecomm.service.CustomerServiceImpl;

@Controller

public class UserCartController {
	 @Autowired
	    private CustomerServiceImpl usersDetailService;
	    
	    
	    /* * Initially getCart method is called to get user card items from database*/
	     
	    @RequestMapping(value="/cart")
	    public String getCartItems(@AuthenticationPrincipal User activeUser){
	    	System.out.println("hello");
	    	Customers usersDetail = usersDetailService.getUserByUsername (activeUser.getUsername());
	        int cartId = usersDetail.getCart().getCartId();

	        return "redirect:/cart/"+cartId;
	    }
	    
	     /** getCartRedirect method is called from getCart method to set retrieved cart from the database.*/
	     
	    @RequestMapping("/cart/{cartId}")
	    public String getNewUrl(@PathVariable (value = "cartId") int cartId, Model model) {
	        model.addAttribute("cartId", cartId);

	        return "cartPage";
	    }


}
