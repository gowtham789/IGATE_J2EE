package com.igate.exception;

public class EventException extends Exception {

	private String message;

	public EventException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
