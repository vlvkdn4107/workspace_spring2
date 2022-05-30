package com.example.demoex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/user")
	public String user() {
		return "hello spring";
	}
	@GetMapping("/home")
	public String home() {
		String temp = "{\r\n"
				+ "	\"name\":\"È«±æµ¿\"\r\n"
				+ "}";
		return temp; 
	}
	@GetMapping("/movie")
	public String movie() {
		String temp = "{\r\n"
				+ "	\"name\":\"¸í·®\",\r\n"
				+ "	\"year\":\"2012\",\r\n"
				+ "	\"actor\":\"ÃÖ¹Î½Ä\"\r\n"
				+ "}\r\n"
				+ "{\r\n"
				+ "	\"name\":\"¸í·®\",\r\n"
				+ "	\"year\":\"2012\",\r\n"
				+ "	\"actor\":\"ÃÖ¹Î½Ä\"\r\n"
				+ "}\r\n"
				+ "{\r\n"
				+ "	\"name\":\"¸í·®\",\r\n"
				+ "	\"year\":\"2012\",\r\n"
				+ "	\"actor\":\"ÃÖ¹Î½Ä\"\r\n"
				+ "}t";
		return temp;
	}
}
