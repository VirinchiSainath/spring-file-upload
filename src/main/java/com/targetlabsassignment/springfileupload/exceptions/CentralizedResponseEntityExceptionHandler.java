package com.targetlabsassignment.springfileupload.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CentralizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> handleResourceNotFoundException(Exception ex, WebRequest request){
		ExceptionEntity exEntity = new ExceptionEntity(new Date(), ex.getMessage());
		
		return new ResponseEntity<Object>(exEntity, HttpStatus.NOT_FOUND);
	}
	
/*	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		ExceptionEntity exEntity = new ExceptionEntity(new Date(), "Sorry for the inconvinence");
		
		return new ResponseEntity<Object>(exEntity, HttpStatus.INTERNAL_SERVER_ERROR);
	}*/

}
