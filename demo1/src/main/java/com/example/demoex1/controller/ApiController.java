package com.example.demoex1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

			

@RestController
@RequestMapping("/api/get")
public class ApiController {
	
	// URL, URI
	// URL은 자원을 요청하는 주소 체게 방식
	// URI은 식별자 방식
	// 스프링에 서는 전부 URI방식을 쓴다.
	
	// http://localhost:9090/api/get/hello
	@GetMapping("/hello")
	public String getHello() {
		return "sayhello";
	}
	// path-variable 방식
	// get --> URI 방식 사용 ( 데이터를 담아서 요청을 하면) // 처리를 하고 // 응답을 해줄수있다
	// 주소를 똑같이 만들고 체게가 똑같이 하나면은 오류가 난다 
	@GetMapping(path = "/path-variable/{name}")
//	http://localhost:9090/api/get/path-variable/[xxx]
	public String queryParam(@PathVariable(name = "name") String name) {
		System.out.println("브라우저에서 들어온 값을 받음" + name);
		return "[["+ name +"]]";
		
	}
	//http://localhost:9090/api/get/path-variable/[xxx]/[xxx]
	@GetMapping(path = "/path-variable/{name}/{age}")
	public String queryParam2(@PathVariable(name = "name")String name, @PathVariable(name = "age") int age) {
		System.out.println("name : " + name);	
		System.out.println("age :" + age);
		return "name : " + name + "," + "age : " + age;
	}
	
	// 문제 1 새로운 주소 만들어서 요청 읍답 (인자값 하나)
	//http://localhost:9090/api/get/path-movie/[???]
	@GetMapping(path = "/path-movie/{name}")
	public String movie(@PathVariable(name = "name")String name) {
		return "[" + name + "]";
	}	
	// 문제 2 새로운 주소 만들어서 요청 읍답 (인자값 두개)
	@GetMapping(path = "/path-movie/{name}/{year}/{actor}")
	public String movie2(@PathVariable(name = "name")String name,@PathVariable(name = "year")int year, @PathVariable(name = "actor")String actor){
		return "[영화이름: " + name + "]" + "," + "[개봉일: " + year + "]" + "," + "[주연: " + actor + "]" ;
	}
	
}
