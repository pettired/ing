package com.ing.atm.exception;

import java.util.Date;

public class ExceptionResponse {

	private String message;
	private Date timestamp;

	public ExceptionResponse(String message, Date timestamp) {
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

}