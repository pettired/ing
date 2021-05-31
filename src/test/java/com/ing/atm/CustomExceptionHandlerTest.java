package com.ing.atm;

import com.ing.atm.exception.CustomExceptionHandler;
import com.ing.atm.exception.ExceptionResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RunWith(MockitoJUnitRunner.class)
public class CustomExceptionHandlerTest {

	@Mock
	WebRequest request;
	
	@Mock
	MethodArgumentTypeMismatchException ex;

	@InjectMocks
	CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);		
	}
	
	@Test
	public void testHandleNoHandlerFoundException_BAD_REQUEST_Success() {
		
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = null;
		NoHandlerFoundException ex = new NoHandlerFoundException("", "", headers);		
		
		ResponseEntity<Object> entity = customExceptionHandler.handleNoHandlerFoundException(ex, headers,
				status, request);
		
		Assert.assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());	
	}
	
	@Test
	public void testHandleNoHandlerFoundException_BAD_REQUEST_Fail() {
		
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = null;
		NoHandlerFoundException ex = new NoHandlerFoundException("", "", headers);		
		
		ResponseEntity<Object> entity = customExceptionHandler.handleNoHandlerFoundException(ex, headers,
				status, request);
		
		Assert.assertNotEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());	
	}
	
	@Test
	public void testHandleBadRequestException_BAD_REQUEST_Success() {
				

		ResponseEntity<ExceptionResponse> entity = customExceptionHandler.handleBadRequestException(ex, request);
		
		Assert.assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());	
	}
	
	@Test
	public void testHandleBadRequestException_BAD_REQUEST_Fail() {
		
		ResponseEntity<ExceptionResponse> entity = customExceptionHandler.handleBadRequestException(ex, request);
		
		Assert.assertNotEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());	
	}
	
	@Test
	public void testHandleHttpRequestMethodNotSupported_METHOD_NOT_ALLOWED_Success() {
		
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = null;
		HttpRequestMethodNotSupportedException ex = new HttpRequestMethodNotSupportedException("GET");
		
		ResponseEntity<Object> entity = customExceptionHandler.handleHttpRequestMethodNotSupported(ex, headers,
				status, request);
		
		Assert.assertEquals(HttpStatus.METHOD_NOT_ALLOWED, entity.getStatusCode());	
	}
	
	@Test
	public void testHandleHttpRequestMethodNotSupported_METHOD_NOT_ALLOWED_Fail() {
		
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = null;
		HttpRequestMethodNotSupportedException ex = new HttpRequestMethodNotSupportedException("GET");
		
		ResponseEntity<Object> entity = customExceptionHandler.handleHttpRequestMethodNotSupported(ex, headers,
				status, request);
		
		Assert.assertNotEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());	
	}
	
	
	
	
	
}
