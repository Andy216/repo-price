package com.price.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.price.exceptions.ErrorException;
import com.price.exceptions.ErrorResponse;

@ControllerAdvice
public class RestApiResponseEntityExceptionHandler {

	@ExceptionHandler(ErrorException.class)
	public ResponseEntity<ErrorResponse> handleCustomDataNotFoundExceptions(Exception e) {

		return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
