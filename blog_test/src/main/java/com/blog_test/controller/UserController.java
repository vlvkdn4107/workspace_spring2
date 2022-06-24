package com.blog_test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 어느 이주소는 어느 jsp를 타는지 컨트롤러
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private HttpSession httpSession;
	@GetMapping("/login_form")
	public String login(){
		return "user/login_form";
	}
	@GetMapping("/join_form")
	public String joinForm() {
		return "user/join_form";
	}
	
	@GetMapping("/logout")
	public String logout() {
		httpSession.invalidate();
		return "redirect:/";
	}
	
}
