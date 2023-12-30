package com.bway.springsecondproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springsecondproject.model.Categories;
import com.bway.springsecondproject.service.CategoriesService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CategoriesController {
	@Autowired
	private CategoriesService catService;
	
    @GetMapping("/categories")
	public String getCat(Model model,HttpSession session) {
		if(session.getAttribute("activeuser") == null) {
			
			return"LoginForm";
		}
    	model.addAttribute("categoryList",catService.getAllCategories());
		return"Categories";
	}
    @GetMapping("/addcategories")
    public String getAddCat() {
    	
    	return"AddCategories";
    }
    @PostMapping("/addcategories")
    public String postAddCat(@ModelAttribute Categories cat) {
    	
    	catService.addCat(cat);
    	return"AddCategories";
    }
    @GetMapping("/cat/delete")
    public String delete(@RequestParam int id) {
    	
    	catService.deleteCat(id);
    	return"redirect:/categories";
    }
    @GetMapping("/cat/edit")
    public String edit(@RequestParam int id,Model model) {
    	
    	model.addAttribute("categoryObject",catService.getCategoryById(id));
    	return"CategoryEdit";
    }
    @PostMapping("/cat/update")
    public String update(@ModelAttribute Categories cat) {
    	
    	catService.updateCat(cat);
    	return"redirect:/categories";
    }
    
    
}
