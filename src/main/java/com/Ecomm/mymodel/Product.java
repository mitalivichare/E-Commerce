package com.Ecomm.mymodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="Product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable
{
	@Id
	@SequenceGenerator(name = "prod_seq", sequenceName = "prod_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "prod_seq")
	@Column(name="ID")
	private int id;
	@NotNull
	@Size(min=2,max=30)
	@Column(name="NAME")
	private String name;
	@Min(1)
	@Column(name="PRICE")
	private double price;
	@Min(1)
	@Column(name="QUANTITY")
	private int qty;
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="IMAGE_PATH")
	private String image;
	@NotBlank
	@Column(name="DESCRIPTION")
	private String description;
	@NotNull
	@Transient
	private MultipartFile file;
	
	public void setFile(MultipartFile mf)
	{
		this.file=mf;
	}

	public void setId(int id){
		this.id =id;
	}
	public void setName(String name){
		this.name =name;
	}
	public void setQty(int qty){
		this.qty =qty;
	}
	public void setPrice(double price){
		this.price =price;
	}
	public void setDescription(String desc){
		this.description=desc;
	}
	public void setCategory(String cat){
		this.category =cat;
	}
	public void setImage(String img){
		this.image =img;
	}
	
	public MultipartFile getFile()
	{
		return file;
	}
	
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public int getQty()
	{
		return qty;
	}
	public double getPrice()
	{
		return price;
	}
	public String getDescription()
	{
		return description;
	}
	public String getCategory()
	{
		return category;
	}
	public String getImage()
	{
		return image;
	}
}
