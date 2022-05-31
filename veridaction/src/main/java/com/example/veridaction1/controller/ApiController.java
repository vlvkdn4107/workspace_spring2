package com.example.veridaction1.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.veridaction1.dto.User;

@RequestMapping("/api")
@RestController
public class ApiController {

	@PostMapping("/user")
	public ResponseEntity<?> user(@Valid @RequestBody User user, BindingResult bindingResult) {
		// 예전 방식
		if (user.getAge() < 1 || user.getAge() > 110) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		// 에러가 발생시 custom해서 프론트 개발자가 잘 처리할수 있도록 설계해야 한다.
		// BindingResult 가 @Vaild에 대한 결과 값을 가지고 있다.
		if (bindingResult.hasErrors()) {
			// 에러가 있다면 여기서 처리
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(error -> {
				FieldError field = (FieldError) error;
				String message = field.getDefaultMessage();
				System.out.println("field : " + field.getField());
				System.out.println("message : " + message);
				sb.append("field : " + field.getField() + "\n");
				sb.append("message : " + message + "\n");
			});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}
		System.out.println(user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
