package com.bway.springsecondproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springsecondproject.utils.Mailutil;

import jakarta.servlet.http.HttpSession;

@Controller
public class ContactController {
	
	@Autowired
	private Mailutil mailutil;
	
	@GetMapping("/contact")
	public String getContact(HttpSession session) {
		if(session.getAttribute("activeuser") == null){
			return"LoginForm";
		}
		return"ContactForm";
	}
	@PostMapping("/contact")
	public String postContact(@RequestParam String toEmail,@RequestParam String subject,@RequestParam String message) {
		
	mailutil.sendEmail(toEmail, subject, message);
		return"ContactForm";
	}
}
