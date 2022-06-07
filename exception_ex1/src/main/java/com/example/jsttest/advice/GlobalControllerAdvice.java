package com.example.jsttest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice(basePackages = "com.example.jsttest.controller") Ư�� ��Ű�������� �����ϰ� �����
//@ControllerAdvice // �丮���� , data(MessageConverter)
@RestControllerAdvice // �̷��� �Ⱦ��� �۷ι��� �ȴ�.
public class GlobalControllerAdvice {
	// ��� ���ܻ�Ȳ�� ó���ϰ� ������ ���
	// ���ܰ� �߻��ϸ� ���� Ŭ������ ã�ƿͼ� ����ó���� �Ѵ�
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e){
		System.out.println("======================================");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		System.out.println("======================================");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	// Ư�� ���� ��Ȳ������ �ٸ� ���� ó���� �ϰ� ������, �ٸ� ������ ����� ������
	// MissingServletRequestParameterException
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e){
		System.out.println("MissingServletRequestParameterException ���ڿ� ����");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}
