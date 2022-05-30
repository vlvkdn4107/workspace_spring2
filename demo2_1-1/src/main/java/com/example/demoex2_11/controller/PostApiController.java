package com.example.demoex2_11.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoex2_11.Dto.UserRequestDto;

@RestController
@RequestMapping("/api2")
public class PostApiController {

	// @RequestBody 에 대한 이해와 Map 구조로 값 받아 보기

	//@Dto를 사용해서 처리해 보기

	// JSON
	//String : value
	//number : value
	//boolean : value
	//object : value  --> {}
	//list : value --> []

	
	/*
	 * {
	 *   "name" : "value",
	 *   "age" : value
	 * }
	 * */
	
	//1 . Map방식
	// http://localhost:9090/api2/post1  (POST)
	@PostMapping("/post1")
	public String post1(@RequestBody Map<String, Object> requestData) {
		System.out.println("post1 test1");
		StringBuffer sb = new StringBuffer();
		
		requestData.entrySet().forEach(entry ->{
			System.out.println("key :" + entry.getKey());
			System.out.println("value :" + entry.getValue());
			sb.append(entry.getKey() + "=" + entry.getValue());
		});
		
		
		return sb.toString();
	}
	// 2. Dto 방식
	// java/mobile
	// 네이트워크 통신 BufferdReader, BufferedWrite ---> 문자열 전송 (json parsing)
	// 왜 문자열이 자동으로 Object가 되는거???
	// 메세지 컨버터 라는 녀석이 자동으로 문자열을 파싱해서 --> UserRequestDto에 맵핑 처리를 해주고있다.
	@PostMapping("/post2")
	public String post2(@RequestBody UserRequestDto userRequestDto) {
		System.out.println(userRequestDto.toString());
		return userRequestDto.toString();
	}
	
}
