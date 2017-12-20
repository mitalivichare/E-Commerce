package com.Ecomm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Ecomm.dao.ProductDAOImpl;
import com.Ecomm.mymodel.Product;

@Service
public class ProductServiceImpl 
{
	@Autowired
	private ProductDAOImpl pdi;
	public void addProduct(Product p)
	{
		System.out.println(pdi);
		System.out.println(p);
		pdi.addProduct(p);
		
	}
	
	public void updateProduct(Product p)
	{
		pdi.updateProduct(p);
	}
	
	public List<Product> listProduct()
	{
		return pdi.listProduct();
	}
	
	public Product getProductById(int id)
	{
		return pdi.getProductById(id);
	}
	public void removeProduct(int id) 
	{
		pdi.removeProduct(id);
	}
	
	public void storeFile(Product p, HttpServletRequest request)
	{
		pdi.storeFile(p,request);
	}

}
