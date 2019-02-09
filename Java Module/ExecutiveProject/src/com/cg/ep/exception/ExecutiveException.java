package com.cg.ep.exception;

public class ExecutiveException extends Exception 
{
	private String message;
	public ExecutiveException(String message) 
	{
		super();
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}
}
