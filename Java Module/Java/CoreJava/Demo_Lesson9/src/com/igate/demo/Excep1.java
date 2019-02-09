package com.igate.demo;

import java.util.Scanner;

public class Excep1 {

	public static void main(String[] args) {
		
		try
		{
		System.out.println("Enter ur choice");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		if(ch==1)
		{
		int x=10/0;
		}
		else if(ch==2)
		{
		int marks[]=new int[2];
		marks[3]=10;
		}
		else
		{
			System.out.println("U chose >2");
		}
		}
		catch(ArithmeticException e) {
			  System.out.println("Divide by 0: " + e);
			} 
		catch(ArrayIndexOutOfBoundsException e) {
			  System.out.println("Array index oob: " + e);
			} 
		catch(Exception e) {
			  System.out.println("Generic Excpetion: " + e);
			}
		finally
		{
			System.out.println("Closing the connections.....");
		}
		System.out.println("After try/catch blocks.");
	}

}
