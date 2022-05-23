package com.flipkart.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlipkartException extends Exception {

	private static final long serialVersionUID = 1L;

	private HttpStatus statusCode;

	public FlipkartException() {
		super();
	}

	public FlipkartException(HttpStatus code, String message) {
		super(message);
		this.statusCode = code;
	}

}
