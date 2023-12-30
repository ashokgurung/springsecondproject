package com.bway.springsecondproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bway.springsecondproject.model.Products;
import com.bway.springsecondproject.service.ProductService;
import com.bway.springsecondproject.utils.ProductExcelView;
import com.bway.springsecondproject.utils.ProductPdfView;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {
	@Autowired
	private ProductService prodService;
	
    @GetMapping("/products")
	public String getProduct(Model model,HttpSession session) {
    	
    	if(session.getAttribute("activeuser") == null) {
    		return"LoginForm";
    	}
    	model.addAttribute("pList",prodService.getAllProducts());
    	
		return"Products";
	}
    @GetMapping("/addproduct")
    public String getAddProduct() {
    	
    	return"AddProducts";
    }
    @PostMapping("/addproduct")
    public String postProduct(@ModelAttribute Products prod) {
    	
    	prodService.addproducts(prod);
    	return"AddProducts";
    }
    @GetMapping("prod/delete")
    public String delete(@RequestParam Long id) {
    	
    	prodService.deleteproducts(id);
    	
    	return"redirect:/products";
    }
    @GetMapping("/prod/edit")
    public String edit(@RequestParam Long id,Model model) {
    	
    	model.addAttribute("pObject",prodService.getProdById(id));
    	
    	return"ProductEdit";
    }
    @PostMapping("/prod/update")
    public String update(@ModelAttribute Products prod) {
    	
    	prodService.updateproducts(prod);
    	
    	return"redirect:/products";
    }
    @GetMapping("/prod/excel") 
    public ModelAndView excel() {
    	
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("pList",prodService.getAllProducts());
    	mv.setView(new ProductExcelView());
    	
    	return mv;
    }
   @GetMapping("/prod/pdf") 
   public ModelAndView pdf() {
   	
	   ModelAndView mv = new ModelAndView();
   	mv.addObject("pList",prodService.getAllProducts());
   	mv.setView(new ProductPdfView());
	   
   	return mv;
   }
}
