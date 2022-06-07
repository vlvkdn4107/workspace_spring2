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
		System.out.println("���ܹ߻�");
		System.out.println("@================================@");
		System.out.println(e.getClass());
		System.out.println("@================================@");
		System.err.println(e.getMessage());
		System.out.println("@================================@");
		System.out.println(e.getCause());;
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	// Get����ϋ� �Ѿ���� PARAMETERS ���� ���� ��� �߻�
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e){
		System.out.println("missingServletRequestParameterException ���� �߻�!");
//		System.out.println(e.getMessage());
		
		String fieldName = e.getParameterName();
		String fieldType = e.getParameterType();
		String invalidValue = e.getMessage();
		System.err.println("fieldName : " + fieldName);
		System.err.println("fieldType : " + fieldType);
		System.err.println("invalidValue : " + invalidValue);
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldName + "�Է��ؾ� �մϴ�");
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		System.out.println("methodArgumentNotValidException ���� �߻�!");
		// Get���� �ٸ��� Post�� �ѹ��� ���� �� ó�� �Ǽ� ���´� (�� List �����̴�)
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
		// ���ÿ� Ȯ�� validation (List)
		System.out.println("constraintViolationException ���� �߻�!!");
		List<CustomError> errorList = new ArrayList<CustomError>();
		e.getConstraintViolations().forEach(error -> {
			String strField =  error.getPropertyPath().toString();
			int index = strField.indexOf("."); // user. << �� �߶󳽴�
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
