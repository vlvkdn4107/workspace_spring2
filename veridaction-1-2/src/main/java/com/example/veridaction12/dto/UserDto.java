package com.example.veridaction12.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/*
 * {
 *  "name":"ȫ�浿",
 *  "age":0,
 *  "email":"a@naver.com"
 * }
 * */
public class UserDto {
	
	@NotBlank
	private String name;
	@Max(value = 110, message = "���̸� �߸� �Է��߽��ϴ�.")
	@Min(value = 0, message = "���̸� �߸� �Է��߽��ϴ�.")
	private int age;
	@Email
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", age=" + age + ", email=" + email + "]";
	}
	
	
	

}
