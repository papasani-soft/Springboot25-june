package com.example.demo.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Product;


public interface ProductService 
{
	public Product create(Product product);
	public ResponseEntity<Product> getProduct();
	public ResponseEntity<List<Product>> getAllProducts();
	public Integer updateProduct();
	public Integer deleteProduct();
}
