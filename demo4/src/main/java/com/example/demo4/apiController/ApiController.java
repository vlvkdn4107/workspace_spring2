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

	// text/plain  <-- contentType 이 text/plain 이 된다.
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}
	
	// application/json
	@PostMapping("/json")
	// 어떠한 Request가 있다면 -->object로 맵핑을 해준다  --> 메서드
	public User json(@RequestBody User user) {
		System.out.println(user.getName());
		return user;
	}
	
	
	// 202, 200  --> 응답을 돌려줄 때 응답 코드를 지정해서 보낼수 있다.
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user){
		// ResponseEntity를 통해서 status, header 등을 설정 할 수 있다.
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	
}
