package com.sample.product.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
@IdClass(ProductInventorySeller.class)
public class ProductInventory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2177397121346580033L;
	@Id
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //@JoinColumn(unique = true)
    private Seller seller;
	@Id
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Product product;
	private Integer availableCount;
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getAvailableCount() {
		return availableCount;
	}
	public void setAvailableCount(Integer availableCount) {
		this.availableCount = availableCount;
	}
	
}
