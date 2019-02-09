package com.cg.event.exception;

public class EventException extends Exception
{
	private String message;

	public String getMessage() {
		return message;
	}

	public EventException(String message) 
	{
		super();
		this.message = message;
	}
	

}
