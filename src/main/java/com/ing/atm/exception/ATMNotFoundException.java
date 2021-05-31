package com.ing.atm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ATMNotFoundException extends RuntimeException {

	/**
	 * Custom Exception to handle Resource not found Exceptions
	 */

	public ATMNotFoundException(String exception) {
		super(exception);
	}

}
