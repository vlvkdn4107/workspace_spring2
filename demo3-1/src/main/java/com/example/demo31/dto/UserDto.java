package com.example.demo31.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDto {
	private String name;
	private String age;
	
	private List<InGame> ingame;
	
	
	public List<InGame> getIngame() {
		return ingame;
	}
	public void setIngame(List<InGame> ingame) {
		this.ingame = ingame;
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
		return "UserDto [name=" + name + ", age=" + age + ", ingame=" + ingame + "]";
	}
	
	

}
