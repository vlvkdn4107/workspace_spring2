package com.example.demoex2_11.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoex2_11.Dto.UserRequestDto;


@RestController
@RequestMapping("/api/get")
public class GetApiController {

	@GetMapping("/hello")
	public String getHello() {
		return "say Hello";
	}
	
	// http;//localhost:9090/api/get/path-variable/{����ڰ� ������}/{����ڰ� ������}
	@GetMapping(path = "/path-variable/{name}/{age}")
	public String queryParam(@PathVariable(name = "name") String name,
							 @PathVariable(name = "age")int age) {
		System.out.println("name" + name);
		System.out.println("age" + age);
		String myName = "[[ "+ name + "]]";
		String myAge = "[[ "+ age + "]]";
		return "name : " + myName + "," + "age : " + myAge;
	}
	
	
	
	// http;//localhost:9090/api/get/query-param1?name=ȫ�浿&email=vlvkdn@naver.com&age=21
	// query parameter ��� (3����)
	// 1. key���� �����ؼ� ���� �޴� ���
	@GetMapping("query-param1")
	public String queryParam1(@RequestParam String name,
							  @RequestParam String email,
							  @RequestParam int age) {
		
		
		return "name : " + name + ", email : " + email + ", age : " + age;
	}
	
	
	
	
	
	// 2. Map�迭 Ȱ�� ���
	@GetMapping("query-param2")
	public String queryparam2(@RequestParam Map<String, String>data){
		StringBuffer sb = new StringBuffer();
		
		data.entrySet().forEach(entry ->{
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println();
			sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
		});
		return sb.toString();
	}
	
	
	
	// 3 Dto Ȱ�� ���
	// Ŭ���̾�Ʈ���� ��û�Ҷ� (Bufferedwrite(����) --> BufferedReader(����) �ߴµ� ���ص��� �ڵ����� ó�� ����!
	// ������̼�(@) �� ������� �ʾƵ� �ȴ�!!!!
	@GetMapping("query-param3")
	public String queryParam3(UserRequestDto userRequestDto) {
		
		return userRequestDto.toString();
	}
	
	
	
	
	
		
	
	
	
}
