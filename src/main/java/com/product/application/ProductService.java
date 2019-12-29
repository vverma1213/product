package com.product.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.domain.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		List product = new ArrayList<>();
		productRepository.findAll().forEach(product::add);
		return product;
	}

	
	 public Product getProduct(Long id) { 
		 return productRepository.findById(id).orElseGet(Product::new);
	 }
	 

	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public void updateProduct(Long id, Product product) {
		productRepository.save(product);
	}

	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
	
	public Integer getProductBySeller(String seller) {
		return productRepository.getNumberOfProductBySeller(seller).size();
	}
}
