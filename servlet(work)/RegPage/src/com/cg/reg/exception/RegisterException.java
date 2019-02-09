package com.cg.reg.exception;

public class RegisterException extends Exception{

	private String message;

	public RegisterException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
