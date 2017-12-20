package com.Ecomm.mymodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Customer")
public class Customers  implements Serializable {
	
	@Id
	@SequenceGenerator(name = "cust_seq", sequenceName = "cust_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "cust_seq")
	@Column(name="CustID")
	int custId;
	
	@Column(name="Cname")
	@NotBlank
	String custname;
	@NotBlank
	
	@Column(name="UserName")
	
	String username;
	@Email
	@Column(name="Email",unique=true)
	@NotBlank
	String email;
	@Column(name="Password")
	@NotBlank
	String password;
	@Column(name="Phone")
	@NotBlank
	String phone;
	@Column(name="Address")
	@NotBlank
	String address;
	@Column(name="Enabled")
	boolean enabled =true;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="shipId")
    private ShippingAddress shippingAddress;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

	public void setEnabled(boolean b)
	{
		enabled=b;
	}
	public boolean getEnabled()
	{
		return enabled;
	}
	
	public void setCustId(int c)
	{
		custId=c;
	}
	public int getCustId()
	{
		return custId;
	}
	public void setCustname(String nm)
	{
		custname= nm;
	}
	public String getCustname()
	{
		return custname;
	}
	public void setEmail(String em)
	{
		email= em;
	}
	public String getEmail()
	{
		return email;
	}
	public void setPassword(String ps)
	{
		password= ps;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setphone(String ph)
	{
		phone= ph;
	}
	public String getPassword()
	{
		return password;
	}
	
	public void setAddress(String ad)
	{
		address= ad;
	}
	public String getAddress()
	{
		return address;
	}
	
	public void setUsername(String aus)
	{
		username= aus;
	}
	public String getUsername()
	{
		return username;
	}
	public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
