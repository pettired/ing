package com.ing.atm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthorizationException extends RuntimeException {

	/**
	 * Custom Exception to handle UnAuthorized Exceptions
	 */

	public AuthorizationException(String exception) {
		super(exception);
	}

}