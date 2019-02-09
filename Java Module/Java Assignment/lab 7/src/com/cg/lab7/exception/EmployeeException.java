package com.cg.lab7.exception;

public class EmployeeException extends Exception{

		protected String message;

		public EmployeeException(String message) {
			super();
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		@Override
		public String toString() {
			return "EmployeeException [message=" + message + "]";
		}
	}

