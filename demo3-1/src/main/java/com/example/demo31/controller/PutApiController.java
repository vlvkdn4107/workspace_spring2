package com.example.demo31.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo31.dto.UserDto;

@RestController
@RequestMapping("/api2")
public class PutApiController {
	@PutMapping("/put/{userId}")
	public UserDto put(@RequestBody UserDto userDto,
					   @PathVariable(name = "userId")Long userId) {
		return userDto;
	}
}
