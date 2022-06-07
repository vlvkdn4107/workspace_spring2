package com.example.exception22.dto;

import lombok.Data;

@Data
public class CustomError {
	// 내가 만든 error 클래스
	private String field;
	private String message;
}
