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

	// @RequestBody �� ���� ���ؿ� Map ������ �� �޾� ����

	//@Dto�� ����ؼ� ó���� ����

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
	
	//1 . Map���
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
	// 2. Dto ���
	// java/mobile
	// ����Ʈ��ũ ��� BufferdReader, BufferedWrite ---> ���ڿ� ���� (json parsing)
	// �� ���ڿ��� �ڵ����� Object�� �Ǵ°�???
	// �޼��� ������ ��� �༮�� �ڵ����� ���ڿ��� �Ľ��ؼ� --> UserRequestDto�� ���� ó���� ���ְ��ִ�.
	@PostMapping("/post2")
	public String post2(@RequestBody UserRequestDto userRequestDto) {
		System.out.println(userRequestDto.toString());
		return userRequestDto.toString();
	}
	
}
