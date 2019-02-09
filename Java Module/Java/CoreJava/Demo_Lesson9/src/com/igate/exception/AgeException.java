package com.igate.exception;

public class AgeException extends Exception{
	
	String message;

	public String getMessage() {
		return message;
	}

	public AgeException(String message) {
		super();
		this.message = message;
	}


}
