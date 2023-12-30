package com.bway.springsecondproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springsecondproject.model.Products;
import com.bway.springsecondproject.repository.ProductRepository;
import com.bway.springsecondproject.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository prodRepo;

	@Override
	public void addproducts(Products prod) {
		prodRepo.save(prod);
	}

	@Override
	public void deleteproducts(Long id) {
		prodRepo.deleteById(id);
	}

	@Override
	public Products getProdById(Long id) {
		return prodRepo.findById(id).get();
	}

	@Override
	public List<Products> getAllProducts() {
		
		return prodRepo.findAll();
	}

	@Override
	public void updateproducts(Products prod) {
         prodRepo.save(prod);		
	}

}
