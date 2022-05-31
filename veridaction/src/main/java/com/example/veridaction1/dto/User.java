package com.example.veridaction1.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/*
 * {
 *  "name":"ȫ�浿",
 *  "age":0,
 *  "email":"a@naver.com",
 *  "phoneNumber": "010-1111-1111"
 * }
 * */





public class User {
	@NotBlank(message = "�̸��� �Է����ּ���.")
	private String name;
	@Max(value = 90, message = "���̸� �߸� �Է��߽��ϴ�.")
	@Min(value = 10, message = "���̸� �߸� �Է��߽��ϴ�.")
	private int age;
	@Email
	private String email;
	private String phoneNumber;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
