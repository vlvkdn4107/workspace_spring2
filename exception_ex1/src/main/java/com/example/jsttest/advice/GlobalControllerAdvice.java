package com.example.jsttest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice(basePackages = "com.example.jsttest.controller") 특정 패키지에서만 동작하게 만들기
//@ControllerAdvice // 뷰리졸뷰 , data(MessageConverter)
@RestControllerAdvice // 이렇게 안쓰면 글로벌이 된다.
public class GlobalControllerAdvice {
	// 모든 예외상황을 처리하고 싶을때 사용
	// 예외가 발생하면 여기 클래스로 찾아와서 예외처리를 한다
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e){
		System.out.println("======================================");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		System.out.println("======================================");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	// 특정 예외 상황에서는 다른 응답 처리를 하고 싶을때, 다른 로직을 만들고 싶을때
	// MissingServletRequestParameterException
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e){
		System.out.println("MissingServletRequestParameterException 문자열 동작");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}
