package com.sample.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sample.product.model.Product;
@Component
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByBrand(String brand);

	List<Product> findByCategory(String category);

	List<Product> findByColor(String color);

}
