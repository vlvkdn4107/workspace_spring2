package com.example.demoex2_12ex.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoex2_12ex.Dto.UserDto;

@RestController
@RequestMapping("/api2")
public class PostController {
	
	
	
	// Map ¹æ½Ä POST
	@PostMapping("/postTest")
	public String postTest(@RequestBody Map<String, Object>data) {
		StringBuffer sb = new StringBuffer();
		
		data.entrySet().forEach(entry ->{
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			sb.append(entry.getKey() + "=" + entry.getValue());
		});
		
		return sb.toString();
	}
	@PostMapping("/postTest1")
	public ArrayList<UserDto> postTest2(@RequestBody UserDto userDto) {
		ArrayList<UserDto> list = new ArrayList<>();
		list.add(userDto);
	
		return list;
	}
	
}
