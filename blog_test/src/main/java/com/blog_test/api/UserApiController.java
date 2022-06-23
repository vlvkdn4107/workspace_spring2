package com.blog_test.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog_test.dto.ResponseDto;
import com.blog_test.model.RoleType;
import com.blog_test.model.User;
import com.blog_test.service.UserService;

@RestController
public class UserApiController {
	@Autowired
	private UserService service;
	@Autowired
	private HttpSession httpSession;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user){
		System.out.println("userApicontroller 호출!");
		user.setRole(RoleType.USER);
		int result = service.saveUser(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
		
	}
	@PostMapping("/api/user/login")
	public ResponseDto<Integer> login(@RequestBody User user){
		System.out.println("api 로그인 호출");
		User principal = service.login(user);
		if(principal != null) {
			httpSession.setAttribute("principal", principal);
			System.out.println("세션 정보가 저장되었습니다.");
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
