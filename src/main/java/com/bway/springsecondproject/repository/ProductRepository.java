package com.bway.springsecondproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springsecondproject.model.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
