package com.example.demoex2.controller;

@RestController
@Re
public class GetApiController {

	@GetMapping("/hello")
	publice String getHello() {
		return "say Hello";
	}
	
	
}
