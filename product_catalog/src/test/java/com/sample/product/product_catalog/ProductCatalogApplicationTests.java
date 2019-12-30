package com.sample.product.product_catalog;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.sample.product.controller.ProductController;
import com.sample.product.dao.InventoryRepository;
import com.sample.product.dao.ProductRepository;
import com.sample.product.dao.SellerRepository;
import com.sample.product.model.Product;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCatalogApplicationTests {
	
	ProductController controller=null;
	ProductRepository repository=null;
	InventoryRepository invRepository=null;
	SellerRepository selRepository=null;
	
	@Before
	public  void setup() {
		controller=new ProductController();
		
		repository=Mockito.mock(ProductRepository.class);
		
		invRepository=Mockito.mock(InventoryRepository.class);
		
		selRepository=Mockito.mock(SellerRepository.class);
		
		ReflectionTestUtils.setField(controller,"repository" , repository);
		ReflectionTestUtils.setField(controller,"invRepository" , invRepository);
		ReflectionTestUtils.setField(controller,"selRepository" , selRepository);
	}

	/*
	 * Sample Test method for ProductController.java
	 */
	@Test
	public void testAddProduct() {
		Product prod=new Product();
		Product dummyExpected=new Product();
		Mockito.when(repository.save(Mockito.any(Product.class))).thenReturn(dummyExpected);
		Assert.assertTrue(controller.addProduct(prod));
	}
	@Test
	public void testAddProductWithException() {
		Product prod=new Product();
		Mockito.when(repository.save(Mockito.any(Product.class))).thenThrow(new NullPointerException("DB Error-Forced Under UT Test"));
		Assert.assertFalse(controller.addProduct(prod));
	}
	
}
