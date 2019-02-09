package com.capgemini.eis.exception;

import com.capgemini.eis.exception.*;

public class MainClass {

	public static void main(String[] args) {
		int sal = 3400;
		try
		{
			calculate(sal);
		}
		catch(EmployeeException e)
		{
			System.out.println(e.getMessage());
		}

	}
	public static void calculate(int sal) throws EmployeeException
	{
		if(sal<3000)
		{
			throw new EmployeeException("Salary is less than 3000");
		}
		else
			System.out.println("Salary is greater than 3000");
	}
}

