package com.Ecomm.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.Ecomm.mymodel.Product;

@Repository
public class ProductDAOImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addProduct(Product p)
	{
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
			session.close();	
	}
	
	@Transactional
	public void updateProduct(Product p)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(p);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> listProduct()
	{
		Session session = this.sessionFactory.openSession();
		
		@SuppressWarnings("deprecation")
		List<Product> pList = session.createQuery("from Product").list();
	
		return pList;
	}
	
	public Product getProductById(int id) 
	{
		Session session = this.sessionFactory.openSession();
		Product p = (Product) session.load(Product.class, new Integer(id));
		return p;
	}
	
	@Transactional
	public void removeProduct(int id) 
	{
		Session session = this.sessionFactory.openSession();
		
		Product p = (Product) session.load(Product.class, new Integer(id));
		Transaction tx=session.beginTransaction();
		if(null != p)
		{
			session.delete(p);
		}
		tx.commit();
		session.close();

	}
	
	/*public void storeFile(Product p)
	{
		MultipartFile file=p.getFile();
		if (!file.isEmpty())
		{	
			try
			{
				byte[] bytes = file.getBytes();
				File serverFile = new File("D:/Mitali/Workspace1/ShreeEStore/src/main/webapp/resources/"+p.getCategory()+"/"+p.getImage());
				serverFile.createNewFile();
				BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
					
		}
	}*/
	@SuppressWarnings("deprecation")
	public void storeFile(Product p, HttpServletRequest request)
	{
		System.out.println(request.getRealPath("/"));
		 String path=request.getRealPath("/")+"resources\\"+p.getCategory()+"\\"+p.getImage();
		 System.out.println(path);
		MultipartFile file= p.getFile();
	
		if (!file.isEmpty()) {
			
		try{
		byte[] bytes =file.getBytes();
		System.out.println(file.getOriginalFilename());
		
		
		File serverFile = new File(path);
		serverFile.createNewFile();
	
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
			
	}
	}

}

