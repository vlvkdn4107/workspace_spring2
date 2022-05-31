package com.example.demo4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * {
 * 	"name" : "kkk",
 *  "age" : 30,
 *  "phoneNumber" : "10101010",
 *  "address" : "부산시 해운대구"
 * 
 * 
 * 
 * */

@JsonInclude(JsonInclude.Include.NON_NULL) // null 값을 내려주지 않고 싶을때 사용 한다.
public class User {
	private String name;
	private int age;
	@JsonProperty("phone_number")
	private String phoneNumber;
	private String address;
	
	private String idNumber;
	
	
	
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	
}
