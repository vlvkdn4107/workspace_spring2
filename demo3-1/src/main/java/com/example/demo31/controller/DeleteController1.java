package com.example.demo31.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api3")
public class DeleteController1 {
	// http://localhost:9090/api3/delete/100/?acount=¿¨
	// ?acount=¿¨ << QUERY PARAMETERS
	@DeleteMapping("/delete/{userId}")
	public void delete(@PathVariable String userId, @RequestParam String acount) {
		
	}
	
}
