package com.bway.springsecondproject.service;

import java.util.List;

import com.bway.springsecondproject.model.Categories;

public interface CategoriesService {

	void addCat(Categories cat);
	void deleteCat(int id);
	void updateCat(Categories cat);
	Categories getCategoryById(int id);
	List<Categories> getAllCategories();
		
}
