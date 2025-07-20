package com.spidertech.libarySp.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spidertech.libarySp.services.exceptions.NameNotNullException;
import com.spidertech.libarySp.services.exceptions.NoResultsFoundException;
import com.spidertech.libarySp.services.exceptions.ResourceNotDeleteAssociationsException;
import com.spidertech.libarySp.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExcepetionsHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){
		String mensage = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorResponse err = new ErrorResponse(Instant.now(), status.value(), mensage, e.getMessage(), request.getRequestURI());
	
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(NameNotNullException.class)
	public ResponseEntity<ErrorResponse> nameNotNullException(NameNotNullException e, HttpServletRequest request){
		String mensage = "Null name attribute";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErrorResponse err = new ErrorResponse(Instant.now(), status.value(), mensage, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(ResourceNotDeleteAssociationsException.class)
	public ResponseEntity<ErrorResponse> resourceNotDeleteAssociationsException(ResourceNotDeleteAssociationsException e, HttpServletRequest request){
		String mensage = "Resource with assosiations";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErrorResponse err = new ErrorResponse(Instant.now(), status.value(), mensage, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(NoResultsFoundException.class)
	public ResponseEntity<Void> noResultsFoundException(NoResultsFoundException e){
		return ResponseEntity.noContent().build();
	}
	
}
