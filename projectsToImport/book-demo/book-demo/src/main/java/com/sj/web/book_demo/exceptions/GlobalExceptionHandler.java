package com.sj.web.book_demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	   @ExceptionHandler(BookNotFoundException.class)
	   public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException e) {
		   
		   
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		   
		   
	   }
	    
	   @ExceptionHandler(DuplicateIdException.class)
	   public ResponseEntity<String> handleDuplicateIdException(DuplicateIdException e) {
		   
		   
		   return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		   
		   
	   }

}
