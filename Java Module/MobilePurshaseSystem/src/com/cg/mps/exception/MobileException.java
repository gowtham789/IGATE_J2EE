package com.cg.mps.exception;

public class MobileException extends Exception
{
	private String message;
	
	

	public MobileException(String message) 
	{
		super();
		this.message = message;
	}



	public String getMessage() {
		return message;
	}
}
