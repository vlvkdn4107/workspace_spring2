package com.example.jsttest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	// http://localhost:9090/board/index
	@GetMapping("/index")
	public String index() {
		System.out.println("1111111111");
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {
		// /WEB-INF/views/home.jsp
		return "home";
	}
	
}
