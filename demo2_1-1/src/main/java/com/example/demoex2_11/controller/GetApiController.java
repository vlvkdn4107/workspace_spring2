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
	
	// http;//localhost:9090/api/get/path-variable/{사용자가 보낸값}/{사용자가 보낸값}
	@GetMapping(path = "/path-variable/{name}/{age}")
	public String queryParam(@PathVariable(name = "name") String name,
							 @PathVariable(name = "age")int age) {
		System.out.println("name" + name);
		System.out.println("age" + age);
		String myName = "[[ "+ name + "]]";
		String myAge = "[[ "+ age + "]]";
		return "name : " + myName + "," + "age : " + myAge;
	}
	
	
	
	// http;//localhost:9090/api/get/query-param1?name=홍길동&email=vlvkdn@naver.com&age=21
	// query parameter 방식 (3가지)
	// 1. key값을 지정해서 값을 받는 방식
	@GetMapping("query-param1")
	public String queryParam1(@RequestParam String name,
							  @RequestParam String email,
							  @RequestParam int age) {
		
		
		return "name : " + name + ", email : " + email + ", age : " + age;
	}
	
	
	
	
	
	// 2. Map계열 활용 방식
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
	
	
	
	// 3 Dto 활용 방식
	// 클라이언트에서 요청할때 (Bufferedwrite(전송) --> BufferedReader(응답) 했는데 안해도됨 자동으로 처리 해줌!
	// 어노테이션(@) 을 사용하지 않아도 된다!!!!
	@GetMapping("query-param3")
	public String queryParam3(UserRequestDto userRequestDto) {
		
		return userRequestDto.toString();
	}
	
	
	
	
	
		
	
	
	
}
