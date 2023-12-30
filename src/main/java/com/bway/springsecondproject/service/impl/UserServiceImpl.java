package com.bway.springsecondproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springsecondproject.model.User;
import com.bway.springsecondproject.repository.UserRepository;
import com.bway.springsecondproject.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepo;

	@Override
	public void userSignup(User user) {
		userRepo.save(user);
	}

	@Override
	public void updateuser(User user) {
		userRepo.save(user);
	}

	@Override
	public User userLogin(String email, String psw) {
		return userRepo.findByEmailAndPassword(email, psw);
	}

}
