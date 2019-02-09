package com.cg.proj.exception;

public class ProjectException extends Exception{
	
	private String message;

	public ProjectException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
