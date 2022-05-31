package com.example.demo3.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PutRequestDto {

	private String name;
	private String age;
	
	private List<CarDto> carList;
	
	
	
	
	
	
	public List<CarDto> getCarList() {
		return carList;
	}
	public void setCarList(List<CarDto> carList) {
		this.carList = carList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "PutRequestDto [name=" + name + ", age=" + age + ", carList=" + carList + "]";
	}
	
	
	
	
	
	// List (����Ÿ��)
	
	
}
