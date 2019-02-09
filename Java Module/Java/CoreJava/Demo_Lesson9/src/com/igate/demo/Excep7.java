package com.igate.demo;

import java.util.Scanner;

import com.igate.exception.AgeException;

public class Excep7 {

	public static void main(String[] args) {

		int age;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the age :");
		age=sc.nextInt();
		
		try
		{
			if(age<16 || age>35)
			{
				AgeException ag=new AgeException("Age should be 16-35");
				throw ag;
			}
		}
		catch(AgeException ag)
		{
			System.out.println(ag.getMessage());
		}
	}

}
