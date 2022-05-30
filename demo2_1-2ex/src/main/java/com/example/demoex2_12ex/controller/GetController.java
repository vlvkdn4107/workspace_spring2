package com.example.demoex2_12ex.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoex2_12ex.Dto.UserDto;

@RestController
@RequestMapping("/api/get/test")
public class GetController {
	
	// Dto 방식
	@GetMapping("test1")
	public String test1(UserDto userDto) {
		ArrayList<UserDto> userDto1 = new ArrayList<>();
		userDto1.add(userDto);
		userDto1.add(userDto);
		return userDto1.toString();
	}
	// key방식
	@GetMapping("test1-key")
	public String test1Key(@RequestParam String name,
						   @RequestParam int age,
						   @RequestParam String address){
		return "name : " + name + ", age : " + age +", address : " + address;
	}
	// Map 방식
	@GetMapping("test1-Map")
	public String test1Map(@RequestParam Map<String, String> data) {
		StringBuffer sb = new StringBuffer();
			data.entrySet().forEach(entryset ->{
			sb.append(entryset.getKey() + "=" + entryset.getValue() + "\n");
		});
		return sb.toString();
	}
	
	// path
	@GetMapping(path = "/test1-path/{name}/{age}")
	public String test1Path(@PathVariable(name = "name")String name,
							@PathVariable(name = "age")int age) {
		String myName = "[[" + name + "]]";
		String myAge = "!!" + age + "!!";
		return "name :" + myName + ", age :" + myAge;
	}
	

}
