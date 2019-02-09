package com.cg.demos;

public class CommandLine {

	public static void main(String[] args) {
		System.out.println("Welcome "+args[0]);
		System.out.println("The number of Arguments Are :"+args.length);

		int result=0;
		int num1=Integer.parseInt(args[1]);
		int num2=Integer.parseInt(args[2]);
		result=num1+num2;
		
		System.out.println("The sum of Numbers is "+result);
	}

}
