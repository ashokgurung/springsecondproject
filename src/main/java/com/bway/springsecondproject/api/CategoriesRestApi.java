package com.bway.springsecondproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bway.springsecondproject.model.Categories;
import com.bway.springsecondproject.service.CategoriesService;

@RestController
public class CategoriesRestApi {
	@Autowired
	private CategoriesService catService;
    
	@GetMapping("/api/cat/list")
	public List<Categories> getAll() {
		
		return catService.getAllCategories();
	}
	
	@GetMapping("/api/cat/{id}")
	public Categories getOne(@PathVariable int id) {
		
		return catService.getCategoryById(id);
	}
	@PostMapping("/api/cat/add")
	public String add(@RequestBody Categories cat) {
		
		catService.addCat(cat);
		return"success";
	}
	@DeleteMapping("/api/cat/delete/{id}")
	public String delete(@PathVariable int id) {
		
	catService.deleteCat(id);
		return"success";
	}
	@PutMapping("/api/cat/update")
	public String update(@RequestBody Categories cat) {
		
		catService.updateCat(cat);
		return"success";
	}
	@GetMapping("/api/cat/j2o")
	public String jasonToObject() {
		
		RestTemplate temp = new RestTemplate();
		Categories c = temp.getForObject("http://localhost:8080/api/cat/10", Categories.class);
		
		return"CategoryName="+c.getCategoryName();
	}
	
	@GetMapping("/api/cat/ja2oa")
	public String jasonArrayToObjectArray() {
		
		RestTemplate rt = new RestTemplate();
		Categories[] cat = rt.getForObject("http://localhost:8080/api/cat/list", Categories[].class);
		
		return"CategoryName="+cat[1].getCategoryName();
	}
}
