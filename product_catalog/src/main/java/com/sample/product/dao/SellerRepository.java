package com.sample.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.product.model.Seller;

public interface SellerRepository  extends JpaRepository<Seller, Integer>  {

}
