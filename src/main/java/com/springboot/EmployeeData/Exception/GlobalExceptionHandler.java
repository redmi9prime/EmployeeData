package com.springboot.EmployeeData.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalExceptionHandler {

	//handling specific exception
		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException exception,WebRequest request){
			errorDetails errordetails = new errorDetails(exception.getMessage(),request.getDescription(false));
			return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
		}
}
