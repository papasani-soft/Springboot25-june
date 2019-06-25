package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;
	
	@Override
	public Product create(Product product) {
		
		return productDao.save(product);
	}

	@Override
	public ResponseEntity<Product> getProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Product>> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteProduct() {
		// TODO Auto-generated method stub
		return null;
	}
}
