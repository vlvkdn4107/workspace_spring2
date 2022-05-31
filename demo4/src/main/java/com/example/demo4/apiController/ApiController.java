package com.example.demo4.apiController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	// text/plain  <-- contentType �� text/plain �� �ȴ�.
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}
	
	// application/json
	@PostMapping("/json")
	// ��� Request�� �ִٸ� -->object�� ������ ���ش�  --> �޼���
	public User json(@RequestBody User user) {
		System.out.println(user.getName());
		return user;
	}
	
	
	// 202, 200  --> ������ ������ �� ���� �ڵ带 �����ؼ� ������ �ִ�.
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user){
		// ResponseEntity�� ���ؼ� status, header ���� ���� �� �� �ִ�.
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	
}
