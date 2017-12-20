
package com.Ecomm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.Ecomm.service.ProductServiceImpl;
import com.Ecomm.mymodel.Product;

@Controller
public class HelloController
{
	
	@Autowired
	private ProductServiceImpl psi;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	   public String index()
	{
		   return "index";
	}
	
	@RequestMapping(value="/aboutus", method = RequestMethod.GET)
	public String about_us()
	{
		return "About_us";
	}
	
	@RequestMapping("/contactus")
	public String contact_us()
	{
		return "Contact_us";
	}
	
	
	@RequestMapping(value="/disp", method = RequestMethod.GET)
	public String displaypage()
	{
		return "disptable";
	}
	
	@RequestMapping(value="/details", method=RequestMethod.GET )
	public String DetailsPage()
	{
		return "DisplayDetails";
	}
	
	@RequestMapping(value="/data", method=RequestMethod.GET )
	public @ResponseBody List<Product> Data()
	{
		
		return psi.listProduct();	
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView addprod()
	{
		return new ModelAndView("Add","product",new Product());
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String AddActionPage(@ModelAttribute("product") @Validated Product p, BindingResult br, Model model)
	{
		if (br.hasErrors())
		{
		System.out.println(br.getErrorCount());	
			return "Add";
		}
		else
		{
			p.setImage(p.getFile().getOriginalFilename());
			psi.storeFile(p);
			psi.addProduct(p);
			return "Addmore";
		}
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView editPage(@RequestParam("id") int id)
	{
		return new ModelAndView("Edit","product",psi.getProductById(id));
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String EditActionPage(@ModelAttribute("product") @Validated Product p, BindingResult br, Model model)
	{
		if (br.hasErrors())
		{
			System.out.println(br.getErrorCount());
			return "Edit";
		}
		else
		{
			p.setImage(p.getFile().getOriginalFilename());
			psi.storeFile(p);
			psi.updateProduct(p);
			return "index";
		}
		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletePage()
	{
		return "Delete";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String deleteActionpagee(@RequestParam("id") int id)
	{
		psi.removeProduct(id);
		return "index";
	}
}