package com.Ecomm.mymodel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Cart")
public class Cart  implements Serializable {
	@Id
	@SequenceGenerator(name = "cart_seq", sequenceName = "cart_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "cart_seq")
	@Column(name="CartId")
	private int cartId;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;
	
	 	@OneToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "custId")
	    @JsonIgnore
	    private Customers usersDetail;
	
		private double grandTotal;

	    public int getCartId() {
	        return cartId;
	    }

	    public void setCartId(int cartId) {
	        this.cartId = cartId;
	    }

	    public List<CartItem> getCartItems() {
	        return cartItems;
	    }

	    public void setCartItems(List<CartItem> cartItems) {
	        this.cartItems = cartItems;
	    }

	    public double getGrandTotal() {
	        return grandTotal;
	    }

	    public void setGrandTotal(double grandTotal) {
	        this.grandTotal = grandTotal;
	    }
	    
	    public Customers getUsersDetail() {
			return usersDetail;
		}

		public void setUsersDetail(Customers usersDetail) {
			this.usersDetail = usersDetail;
		}

}
