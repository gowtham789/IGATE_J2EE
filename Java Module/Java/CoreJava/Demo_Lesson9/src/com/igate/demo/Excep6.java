package com.igate.demo;

public class Excep6 {
	public static void main(String[] args) {
	
		int age=12;
		
		try
		{
			if(age<18)
			{
				ArithmeticException a=new ArithmeticException("Age < 18");
				String s1=new String("Hai");
				throw a; 
			}
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Error Occured ! "+ae.getMessage());
		}
		
	}
}
