package com.spidertech.libarySp.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spidertech.libarySp.services.exceptions.NameNotNullException;
import com.spidertech.libarySp.services.exceptions.NoResultsFoundException;
import com.spidertech.libarySp.services.exceptions.ResourceNotAvailableException;
import com.spidertech.libarySp.services.exceptions.ResourceNotDeleteAssociationsException;
import com.spidertech.libarySp.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionsHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> resourceNotFoundException(Throwable e, HttpServletRequest request) {
		var mensage = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		var err = new ErrorResponse(Instant.now(), status.value(), mensage, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(NameNotNullException.class)
	public ResponseEntity<ErrorResponse> nameNotNullException(Throwable e, HttpServletRequest request) {
		var mensage = "Null name attribute";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		var err = new ErrorResponse(Instant.now(), status.value(), mensage, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(ResourceNotDeleteAssociationsException.class)
	public ResponseEntity<ErrorResponse> resourceNotDeleteAssociationsException(
			Throwable e, HttpServletRequest request) {
		var mensage = "Resource with assosiations";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		var err = new ErrorResponse(Instant.now(), status.value(), mensage, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(NoResultsFoundException.class)
	public ResponseEntity<Void> noResultsFoundException(NoResultsFoundException e) {
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(ResourceNotAvailableException.class)
	public ResponseEntity<ReplyMessage> resourceNotAvailableExcpetion(Throwable e) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		var err = new ReplyMessage(Instant.now(), status.value(), e.getMessage());

		return ResponseEntity.status(status).body(err);
	}

}
