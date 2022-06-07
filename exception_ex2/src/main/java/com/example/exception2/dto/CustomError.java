package com.example.exception2.dto;

import lombok.Data;

@Data
public class CustomError {
	// 내가 만든 error 클래스 정의 해 보기
	private String field;
	private String message;
}
