package com.igate.tms.exception;

public class TraineeException extends Exception
{
	String message;

	
	public TraineeException(String message) {
		super();
		this.message = message;
	}


	public String getMessage()
	{
		return message;
	}
	

}
