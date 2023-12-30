package com.bway.springsecondproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springsecondproject.model.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer>{

}
