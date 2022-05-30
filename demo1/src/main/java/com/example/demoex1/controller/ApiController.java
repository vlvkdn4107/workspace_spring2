package com.example.demoex1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

			

@RestController
@RequestMapping("/api/get")
public class ApiController {
	
	// URL, URI
	// URL�� �ڿ��� ��û�ϴ� �ּ� ü�� ���
	// URI�� �ĺ��� ���
	// �������� ���� ���� URI����� ����.
	
	// http://localhost:9090/api/get/hello
	@GetMapping("/hello")
	public String getHello() {
		return "sayhello";
	}
	// path-variable ���
	// get --> URI ��� ��� ( �����͸� ��Ƽ� ��û�� �ϸ�) // ó���� �ϰ� // ������ ���ټ��ִ�
	// �ּҸ� �Ȱ��� ����� ü�԰� �Ȱ��� �ϳ����� ������ ���� 
	@GetMapping(path = "/path-variable/{name}")
//	http://localhost:9090/api/get/path-variable/[xxx]
	public String queryParam(@PathVariable(name = "name") String name) {
		System.out.println("���������� ���� ���� ����" + name);
		return "[["+ name +"]]";
		
	}
	//http://localhost:9090/api/get/path-variable/[xxx]/[xxx]
	@GetMapping(path = "/path-variable/{name}/{age}")
	public String queryParam2(@PathVariable(name = "name")String name, @PathVariable(name = "age") int age) {
		System.out.println("name : " + name);	
		System.out.println("age :" + age);
		return "name : " + name + "," + "age : " + age;
	}
	
	// ���� 1 ���ο� �ּ� ���� ��û ���� (���ڰ� �ϳ�)
	//http://localhost:9090/api/get/path-movie/[???]
	@GetMapping(path = "/path-movie/{name}")
	public String movie(@PathVariable(name = "name")String name) {
		return "[" + name + "]";
	}	
	// ���� 2 ���ο� �ּ� ���� ��û ���� (���ڰ� �ΰ�)
	@GetMapping(path = "/path-movie/{name}/{year}/{actor}")
	public String movie2(@PathVariable(name = "name")String name,@PathVariable(name = "year")int year, @PathVariable(name = "actor")String actor){
		return "[��ȭ�̸�: " + name + "]" + "," + "[������: " + year + "]" + "," + "[�ֿ�: " + actor + "]" ;
	}
	
}
