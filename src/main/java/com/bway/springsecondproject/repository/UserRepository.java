package com.bway.springsecondproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springsecondproject.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String psw);
}
