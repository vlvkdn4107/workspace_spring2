	package com.example.exception2.advice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception2.dto.CustomError;

@RestControllerAdvice
public class ApicontrollerAdvice {
		
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e){
		System.out.println("예외발생");
		System.out.println("@================================@");
		System.out.println(e.getClass());
		System.out.println("@================================@");
		System.err.println(e.getMessage());
		System.out.println("@================================@");
		System.out.println(e.getCause());;
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	// Get방식일떄 넘어오는 PARAMETERS 값이 없을 경우 발생
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e){
		System.out.println("missingServletRequestParameterException 예외 발생!");
//		System.out.println(e.getMessage());
		
		String fieldName = e.getParameterName();
		String fieldType = e.getParameterType();
		String invalidValue = e.getMessage();
		System.err.println("fieldName : " + fieldName);
		System.err.println("fieldType : " + fieldType);
		System.err.println("invalidValue : " + invalidValue);
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldName + "입력해야 합니다");
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		System.out.println("methodArgumentNotValidException 예외 발생!");
		// Get과는 다르게 Post는 한번에 전부 다 처리 되서 들어온다 (즉 List 구조이다)
		List<CustomError> errorList = new ArrayList<>();
		BindingResult bindingResult = e.getBindingResult();
		bindingResult.getAllErrors().forEach(action -> {
			FieldError field = (FieldError)action;
			String fieldName = field.getField();
			String message = field.getDefaultMessage();
			
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			
			errorList.add(customError);
			
//			System.out.println("action : " + action.toString());
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException e){
		// 동시에 확인 validation (List)
		System.out.println("constraintViolationException 예외 발생!!");
		List<CustomError> errorList = new ArrayList<CustomError>();
		e.getConstraintViolations().forEach(error -> {
			String strField =  error.getPropertyPath().toString();
			int index = strField.indexOf("."); // user. << 을 잘라낸다
			String fieldName = strField.substring(index + 1);
			String message = error.getMessage();
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			errorList.add(customError);
//			System.out.println(strField);
			System.out.println(errorList);
			 
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	
	
}
