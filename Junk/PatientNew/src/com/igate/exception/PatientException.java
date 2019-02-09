package com.igate.exception;

public class PatientException extends Exception{

	private String message; //for holding appropriate exception message 
	
	public PatientException(String message) {
		super();
		this.message = message;
	}
	
	
	public String getMessage() {
		return message;
	}
	
}