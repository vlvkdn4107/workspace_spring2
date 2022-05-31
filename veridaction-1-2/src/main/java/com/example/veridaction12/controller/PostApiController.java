package com.example.veridaction12.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.veridaction12.dto.UserDto;

@RestController
@RequestMapping("/api")
public class PostApiController {

	@PostMapping("/postvalidation")
	public ResponseEntity<?>validation(@Valid @RequestBody UserDto userdto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(error -> {
				FieldError fielderror = (FieldError) error;
				String message = fielderror.getDefaultMessage();
				sb.append("field : " + fielderror.getField() + "\n");
				sb.append("message : " + message + "\n");
			});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}
		return ResponseEntity.status(HttpStatus.OK).body(userdto);
	}
	
}
