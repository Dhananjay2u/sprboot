package com.dj.boot.student;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleExceptionUserDefined(Exception ex, WebRequest request) {
		
		ExceptionResponseBean bean=new ExceptionResponseBean(new Date(), ex.getMessage(), "There is dummy details");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bean);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		// TODO Auto-generated method stub
		ExceptionResponseBean bean=new ExceptionResponseBean(new Date(), ex.getBindingResult().getAllErrors().toString(), "There is validation error, with given input");
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bean);
		return new ResponseEntity(bean,HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponseBean bean=new ExceptionResponseBean(new Date(), ex.getBindingResult().getAllErrors().toString(), "There is validation error, with given input");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bean);
		//return new ResponseEntity(bean,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
