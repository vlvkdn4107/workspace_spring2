package com.blog_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
//	@Autowired
//	private HttpSession httpSession;
	@GetMapping("/login_form")
	public String login(){
		return "user/login_form";
	}
	@GetMapping("/join_form")
	public String joinForm() {
		return "user/join_form";
	}
}
