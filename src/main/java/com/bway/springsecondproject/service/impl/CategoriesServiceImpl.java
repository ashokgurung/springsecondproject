package com.bway.springsecondproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springsecondproject.model.Categories;
import com.bway.springsecondproject.repository.CategoriesRepository;
import com.bway.springsecondproject.service.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService {
	@Autowired
	private CategoriesRepository catRepo;

	@Override
	public void addCat(Categories cat) {
		catRepo.save(cat);
	}

	@Override
	public void deleteCat(int id) {
		catRepo.deleteById(id);
	}

	@Override
	public void updateCat(Categories cat) {
		catRepo.save(cat);
	}

	@Override
	public Categories getCategoryById(int id) {
		
		return catRepo.findById(id).get();
	}

	@Override
	public List<Categories> getAllCategories() {
		return catRepo.findAll();
	}

}
