package com.tencoblog_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tencoblog_test.model.RoleType;
import com.tencoblog_test.model.User_1;
import com.tencoblog_test.repository.UserRepository_1;

@RestController
public class DummyControllerTest_1 {
	
	@Autowired // 자동으로 new 처리
	private UserRepository_1 repository_1;
	
	@PostMapping("/dummy/join_1")
	public String dummy(@RequestBody User_1 user_1) {
		System.out.println("*************************");
		System.out.println(user_1.getUserName());
		System.out.println(user_1.getPassword());
		System.out.println(user_1.getEmail());
		System.out.println("*************************");
		
		user_1.setRole(RoleType.USER);
		
		repository_1.save(user_1);
		
		
		return "회원가입 성공!";
	}
	
}
