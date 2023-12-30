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

import com.bway.springsecondproject.model.Products;
import com.bway.springsecondproject.service.ProductService;

@RestController
public class ProductsRestApi {
	@Autowired
	private ProductService prodService;
	
    @GetMapping("/api/prod/list")
	public List<Products> getAll() {
		
	
    	return prodService.getAllProducts();
	}
    @GetMapping("/api/prod/{id}")
    public Products getOne(@PathVariable Long id) {
    	
    	return prodService.getProdById(id);
    }
    @PostMapping("/api/prod/add")
    public String add(@RequestBody Products prod) {
    	
    	prodService.addproducts(prod);
    	return "success";
    }
    @DeleteMapping("/api/prod/delete/{id}")
    public String delete(@PathVariable Long id) {
    	
    	prodService.deleteproducts(id);
    	return"success";
    }
    @PutMapping("api/prod/update")
    public String update(@RequestBody Products prod) {
    	
    	prodService.updateproducts(prod);
    	return"success";
    }
    @GetMapping("/api/prod/j2o")
    public String jsonToObject() {
    	
    	RestTemplate temp = new RestTemplate();
    	Products p = temp.getForObject("http://localhost:8080/api/prod/1", Products.class);
    	return"ProductName="+p.getProd_name();
    }
    @GetMapping("/api/prod/ja2oa")
    public String jsonArraytoObjArray() {
    	
    	RestTemplate rt = new RestTemplate();
    	Products[]  prods = rt.getForObject("http://localhost:8080/api/prod/list", Products[].class);
    	
    	return"ProductName ="+prods[0].getProd_name();
    }
}
