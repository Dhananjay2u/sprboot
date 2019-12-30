package com.sample.product.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Seller implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2071486884681691426L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String address;
	
	
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seller(Integer id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
