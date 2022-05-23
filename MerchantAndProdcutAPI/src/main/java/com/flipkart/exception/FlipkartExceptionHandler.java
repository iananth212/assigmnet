package com.flipkart.exception;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FlipkartExceptionHandler {

	@ExceptionHandler(value = { FlipkartException.class })
	public ResponseEntity<Object> handleAPIRequestException(FlipkartException vechiclesException) {
		HttpStatus httpStatus = vechiclesException.getStatusCode();
		FlipkartException exception = new FlipkartException(httpStatus, vechiclesException.getMessage());
		return ResponseEntity.status(httpStatus).body(exception.getMessage());
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Object> handleConstraintViolationExceptions(ValidationException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input parameters:");
	}

}
