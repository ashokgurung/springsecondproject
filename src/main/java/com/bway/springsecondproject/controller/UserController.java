package com.bway.springsecondproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springsecondproject.model.User;
import com.bway.springsecondproject.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class UserController {
	
	//private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@GetMapping({"/","/login"})
	public String getLogin() {
		
		return"LoginForm";
	}
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user,Model model,HttpSession session) {
	
		User usr = userService.userLogin(user.getEmail(), user.getPassword());
		if(usr != null) {
			
			log.info("-------login success");
			session.setAttribute("activeuser", usr);
			session.setMaxInactiveInterval(300);
			
		//	model.addAttribute("fname",usr.getFname());
			return"Home";
		}
		log.info("-------- login failed-------");
		model.addAttribute("message","User not found!!");
		return"LoginForm";
	}
	@GetMapping("/signup")
	public String getSignup() {
		
		return"SignupForm";
	}
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user,Model model) {
		
		userService.userSignup(user);
		return"LoginForm";
	}
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		
		log.info("------- logout success --------");
		session.invalidate();
		return"redirect:/login";
	}
    @GetMapping("/home")	
	public String getHome() {
		
		return"Home";
	}
   
	
}
