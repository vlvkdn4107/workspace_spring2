package com.example.demoex2_12ex.Dto;

public class UserDto {
	private String name;
	private int age;
	private int mobile;
	private String address;
	
	
	
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
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "\n" + "[name = " + name + "]," + "\n" 
		      +"[age = " + age + "]," + "\n"
			  +"[mobile = " + mobile + "]," + "\n"
			  +"[address = " + address + "]" + "\n";
		
	}
	

}
