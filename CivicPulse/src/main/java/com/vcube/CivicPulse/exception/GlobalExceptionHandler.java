package com.vcube.CivicPulse.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
		@ExceptionHandler (GrievanceNotFoundException.class)
		public ResponseEntity<ErrorResponse> handleGrievanceNotFound(
				 GrievanceNotFoundException ge,
				 WebRequest request ){				
		
		ErrorResponse error = new ErrorResponse(
				
				 LocalDateTime.now(), 
				HttpStatus.NOT_FOUND.value(), 
				HttpStatus.NOT_FOUND.getReasonPhrase(), 
				ge.getMessage(), 
				request.getDescription(false).replace("uri=", ""));
		
		
		 return new ResponseEntity<>(
	                error,
	                HttpStatus.NOT_FOUND
	        );


		}
}
