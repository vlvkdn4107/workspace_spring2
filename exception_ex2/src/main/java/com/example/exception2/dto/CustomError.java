package com.example.exception2.dto;

import lombok.Data;

@Data
public class CustomError {
	// ���� ���� error Ŭ���� ���� �� ����
	private String field;
	private String message;
}
