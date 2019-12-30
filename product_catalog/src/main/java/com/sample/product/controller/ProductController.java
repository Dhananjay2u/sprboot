package com.sample.product.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.product.dao.InventoryRepository;
import com.sample.product.dao.ProductRepository;
import com.sample.product.dao.SellerRepository;
import com.sample.product.model.Product;
import com.sample.product.model.ProductInventory;
import com.sample.product.model.ProductInventorySeller;
import com.sample.product.model.Seller;

@RestController
@RequestMapping(path="/product-rest")
public class ProductController {

	@Autowired
	private ProductRepository repository;
	@Autowired
	private InventoryRepository invRepository;
	@Autowired
	private SellerRepository selRepository;
	
	@RequestMapping(method=RequestMethod.GET, path="/helloCheck")
	public String checkProductControllerStatus() {
		return "Hello! ProductController is runing fine.";
	}
	
	
	@PostMapping(path="/addProduct")
	public boolean addProduct(@RequestBody Product product) {
		try {
			repository.save(product);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	@GetMapping(path="/getProductById{id}")
	public Product getProductById(@PathVariable Integer id)
	{
		return repository.getOne(id);
	}
	
	@GetMapping(path="/getAllProduct")
	public List<Product> getAllProduct()
	{
		return repository.findAll();
	}
	
	@GetMapping(path="/getProductByBrand/{brand}")
	public List<Product> getProductByBrand(@PathVariable String brand)
	{
		return repository.findByBrand(brand);
	}
	
	@GetMapping(path="/getProductByCategory/{category}")
	public List<Product> getProductByCategory(@PathVariable String category)
	{
		return repository.findByCategory(category);
	}
	
	@GetMapping(path="/getProductByColor/{color}")
	public List<Product> getProductByColor(@PathVariable String color)
	{
		return repository.findByColor(color);
	}
	@GetMapping(path="/getSeller")
	public List<Seller> getSeller()
	{
		return selRepository.findAll();
	}
	
	@GetMapping(path="/getSeller/{id}")
	public Seller getSeller(@PathVariable Integer id)
	{
		return selRepository.getOne(id);
	}
	
	@GetMapping(path="/getProductInventory")
	public List<ProductInventory> getProductInventory()
	{
		return invRepository.findAll();
	}
	
	@GetMapping(path="/getProductBySeller/{seller}/{prod}")
	public List<ProductInventory> getProductBySeller(@PathVariable Integer seller,@PathVariable Integer prod)
	{
		Seller sel=selRepository.getOne(seller);
		ProductInventorySeller pis=new ProductInventorySeller();
		pis.setSeller(sel);
		pis.setProduct(repository.getOne(prod));
		List<ProductInventorySeller> list=new ArrayList<>();list.add(pis);
		return invRepository.findAllById(list);
		
	}
}
