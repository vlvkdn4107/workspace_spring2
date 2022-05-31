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
		// ���� ���
		if (user.getAge() < 1 || user.getAge() > 110) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		// ������ �߻��� custom�ؼ� ����Ʈ �����ڰ� �� ó���Ҽ� �ֵ��� �����ؾ� �Ѵ�.
		// BindingResult �� @Vaild�� ���� ��� ���� ������ �ִ�.
		if (bindingResult.hasErrors()) {
			// ������ �ִٸ� ���⼭ ó��
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
