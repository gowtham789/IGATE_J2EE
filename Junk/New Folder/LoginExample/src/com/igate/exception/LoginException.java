package com.igate.exception;

public class LoginException extends Exception{

			private String message;

			public LoginException(String message) {
				super();
				this.message = message;
			}

			public String getMessage() {
				return message;
			}	

}
