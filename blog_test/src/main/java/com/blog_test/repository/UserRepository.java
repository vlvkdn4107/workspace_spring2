package com.blog_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog_test.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsernameAndPassword(String username, String password);
	
	
}
