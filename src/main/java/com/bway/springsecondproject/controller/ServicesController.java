package com.bway.springsecondproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicesController {
    @GetMapping("/services")
	public String getServices() {
		
		return"Services";
	}
}
