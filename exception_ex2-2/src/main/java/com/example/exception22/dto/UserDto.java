package com.example.exception22.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDto {

	@NotNull
	@Size(min =2, max = 10)
	private String name;
	
	@Min(1)
	@NotNull
	private Integer age;
	
}
