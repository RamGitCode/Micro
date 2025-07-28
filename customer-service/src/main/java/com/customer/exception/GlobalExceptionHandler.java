package com.customer.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ProblemDetail> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex)
	{
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
		problemDetail.setTitle("Customer Already Exists ");
		problemDetail.setDetail(ex.getMessage());
		problemDetail.setProperty("Timestamp", Instant.now());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(problemDetail);
		
	}
	
	
	
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ProblemDetail> handleCustomerNotFound(CustomerNotFoundException ex)
	{
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
		problemDetail.setTitle("Customer not found");
		problemDetail.setDetail(ex.getMessage());
		problemDetail.setProperty("Timestamp", Instant.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
		
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ProblemDetail> handleGenericErrors(Exception ex)
	{
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		problemDetail.setTitle("INTERNAL_SERVER_ERROR");
		problemDetail.setDetail(ex.getMessage());
		problemDetail.setProperty("Timestamp", Instant.now());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetail);
		
	}
}
