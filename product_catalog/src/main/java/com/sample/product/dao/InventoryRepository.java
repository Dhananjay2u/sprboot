package com.sample.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.product.model.ProductInventory;
import com.sample.product.model.ProductInventorySeller;
import com.sample.product.model.Seller;

public interface InventoryRepository extends JpaRepository<ProductInventory, ProductInventorySeller> {

}
