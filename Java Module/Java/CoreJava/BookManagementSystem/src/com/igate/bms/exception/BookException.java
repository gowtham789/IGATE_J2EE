package com.igate.bms.exception;

public class BookException extends Exception{

	private String message;

	public BookException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
