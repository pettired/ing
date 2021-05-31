package com.ing.atm.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
																HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("Invalid request, Please check your Request again",
				new Date());
		logger.info("Custom 400 Exception being thrown: Invalid Request URL");

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestException(MethodArgumentTypeMismatchException ex,
																			 WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				"Something is not right in your request, Please Check your City again", new Date());
		logger.info("Custom 400 Exception being thrown: Invalid City");

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AuthorizationException.class)
	public final ResponseEntity<ExceptionResponse> handleUserNotAuthorizedException(AuthorizationException ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("Unauthorized access", new Date());
		logger.info("Custom 401 Exception being thrown: Invalid username or password");

		return new ResponseEntity<>(exceptionResponse, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public final ResponseEntity<ExceptionResponse> handleUserForbiddenException(AccessDeniedException ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("User is forbidden to access this content", new Date());
		logger.info("Custom 403 Exception being thrown: User is forbidden to access this URL");

		return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
	}
	

	@ExceptionHandler(ATMNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(ATMNotFoundException ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("No ATMS found for this city", new Date());
		logger.info("Custom 404 Exception being thrown: No ATMS found for this city");

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse errorDetails = new ExceptionResponse("Invalid HTTP operation is used, please check", new Date());
		logger.info("Custom 405 Exception being thrown: Method Not allowed, try GET Method");

		return new ResponseEntity<>(errorDetails, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleInternalServerError(Exception ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("Oops! Something went wrong, please try again later",
				new Date());
		logger.info("Custom 500 Exception being thrown: Internal Server Error");

		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	

}
