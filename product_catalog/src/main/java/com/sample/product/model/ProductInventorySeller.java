package com.sample.product.model;

import java.io.Serializable;

public class ProductInventorySeller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2406250220708420313L;
	private Seller seller;
	private Product product;
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
	
}
