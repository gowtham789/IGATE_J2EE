package com.igate.eis.exception;

public class EmployeeException extends Exception {
	
		String message;

		public String getMessage() 
		{
			return message;
		}

		public EmployeeException(String message) 
		{
			super();
			this.message = message;
		}


	}



