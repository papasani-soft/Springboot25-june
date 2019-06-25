package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
@Id
@Column(name="ID")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTS_SEQ")
@SequenceGenerator(sequenceName = "products_seq", allocationSize = 1, name = "PRODUCTS_SEQ")
private Integer productId;
@Column(name="NAME")
private String productName;
@Column(name="COST")
private Integer productCost;
@Column(name="AVAILABILITY")
private Integer available;
public Integer getProductId() {
	return productId;
}
public void setProductId(Integer productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public Integer getProductCost() {
	return productCost;
}
public void setProductCost(Integer productCost) {
	this.productCost = productCost;
}
public Integer getAvailable() {
	return available;
}
public void setAvailable(Integer available) {
	this.available = available;
}

}
