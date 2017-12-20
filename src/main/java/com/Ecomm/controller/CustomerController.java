package com.Ecomm.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Ecomm.mymodel.Customers;

import com.Ecomm.service.CustomerServiceImpl;


@Controller
public class CustomerController {
	@Autowired
	private CustomerServiceImpl csi;
	
	 @RequestMapping(value="/login", method = RequestMethod.GET)
	 public String login() {
	 
	  return "Login";
	 
	 }
	 @RequestMapping(value="/fail2login", method = RequestMethod.GET)
	 public ModelAndView loginerror(ModelMap model) {
	 
	
	  return new ModelAndView("Login","error",true);
	 
	 }
	@RequestMapping(value="/register" ,method=RequestMethod.GET )
	public ModelAndView RegisterPage()
	{
		return new ModelAndView("Register","customer",new Customers());
	}
	@RequestMapping(value="/register" ,method=RequestMethod.POST )
	public ModelAndView RegisterActionPage(@ModelAttribute("customer") @Validated Customers c, BindingResult result, Model model)
	{
		if (result.hasErrors()) {
			
			return new  ModelAndView( "Register");
		}
		else{
			  csi.addCustomer(c);
			
			return  new ModelAndView("Login","logoutmsg","Registered Sucessfully.Please Login to your Account.");
			
		}
		
	}
	
	 @RequestMapping(value="/logout", method = RequestMethod.GET)
	 public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 if (auth != null) {
		 new SecurityContextLogoutHandler().logout(request, response, auth);
		 }
	 
	  return new ModelAndView("Login","logoutmsg", "Logged Out Successfully");
	 
	 }
	 @RequestMapping(value = "/welcome", method = RequestMethod.GET)
	    public String printWelcome(ModelMap model, Principal principal) {

	     //   String name = principal.getName();
	     //   model.addAttribute("username", name);
	     //   System.out.println(name);
	        return "index";

	    }


}
