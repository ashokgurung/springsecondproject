package com.bway.springsecondproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

	@GetMapping("/info")
	public String getInfo() {
		
		return"Info";
	}
}
