package com.bway.springsecondproject.service;

import com.bway.springsecondproject.model.User;

public interface UserService  {
	
	void userSignup(User user);
	
	void updateuser(User user);
	
	User userLogin(String email, String psw);
	
}
