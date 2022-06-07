package com.example.exception22.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception22.dto.UserDto;

@RestController
@RequestMapping("/api")
@Validated
public class ApiController {

	@GetMapping("/user")
	public UserDto user(@Size(min = 2,max = 10) @RequestParam(required = true) String name, 
						@NotNull
						@Min(1)
						@RequestParam(required = true) Integer age) {
		UserDto userDto = new UserDto();
		userDto.setName(name);
		
		int mAge = age + 2;
		userDto.setAge(mAge);
		return userDto;
	}
	@PostMapping("/user")
	public UserDto user(@Valid @RequestBody UserDto userDto) {
		return userDto;
	}
	
}
