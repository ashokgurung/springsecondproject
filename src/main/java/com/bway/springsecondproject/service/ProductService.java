package com.bway.springsecondproject.service;

import java.util.List;

import com.bway.springsecondproject.model.Products;

public interface ProductService {

	void addproducts(Products prod);
	void deleteproducts(Long id);
	void updateproducts(Products prod);
	Products getProdById(Long id);
	List<Products> getAllProducts();
}
