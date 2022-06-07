package com.example.exception22.advice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.exception22.dto.CustomError;

@RestControllerAdvice
public class ApicontrollerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e){
		System.out.println("예외발생@@@@!!!!!!");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	
	//Get방식 예외 처리
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e){
		System.out.println("missingServletRequestParameterException 예외 발생!");
		String fieldName = e.getParameterName();
		String fieldType = e.getParameterType();
		String message = e.getMessage();
		System.out.println("fieldName : " + fieldName);
		System.out.println("fieldType : " + fieldType);
		System.out.println("message : " + message);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldName + "입력 해야됩니다.");
	}
	// Get방식 List식으로 전부 출력해서 예외 처리
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException e){
		System.out.println("constraintViolationException 예외 발생!!");
		List<CustomError> errorList = new ArrayList<>();
		e.getConstraintViolations().forEach(error -> {
			String strField = error.getPropertyPath().toString();
			int index = strField.indexOf(".");
			String fieldName = strField.substring(index + 1);
			String message = error.getMessage();
			
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			errorList.add(customError);
			System.out.println(customError);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
		System.out.println("methodArgumentTypeMismatchException 예외 발생!");
		String check = e.getClass() +"타입이 틀렸습니다.";
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(check);
	}
	
	
	// Post 예외 처리
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		System.out.println("methodArgumentNotValidException 예외 발생");
		List<CustomError> errorList = new ArrayList<>();
		BindingResult bindingResult = e.getBindingResult();
		bindingResult.getAllErrors().forEach(error ->{
			FieldError fieldError = (FieldError) error;
			String fieldName = fieldError.getField();
			String message = fieldError.getDefaultMessage();
			
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			
			errorList.add(customError);
		});;
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	
	
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException e){
		System.out.println("HttpMessageNotReadableException 예외 발생!");
		System.out.println("getLocalizedMessage : " + e.getLocalizedMessage());
		System.out.println("getHttpInputMessage : " + e.getHttpInputMessage());
		String check = e.getHttpInputMessage() + "특부문자 확인 부탁!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(check);
	}
}
