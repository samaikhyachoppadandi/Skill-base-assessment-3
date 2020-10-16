package com.wellsfargo.fsd.sba3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.sba3.exception.CustomException;

@RestControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> handleImsException(CustomException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
