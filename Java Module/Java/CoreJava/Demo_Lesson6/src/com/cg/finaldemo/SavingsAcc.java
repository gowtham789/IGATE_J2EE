package com.cg.finaldemo;

public class SavingsAcc extends Account{

	/* Does not work if display is final
	 * void display()
	 * {
	 * }
	 */
	void display1()
	{
		//percentage=9.3f;
		System.out.println("Welcome, Interest rate is "+percentage);
	}
	
	public static void main(String args[])
	{
		SavingsAcc s1=new SavingsAcc();
		s1.display1();
	}
}
