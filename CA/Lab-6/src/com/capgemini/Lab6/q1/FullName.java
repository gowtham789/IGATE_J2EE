package com.capgemini.Lab6.q1;
import java.util.Scanner;
import com.capgemini.Lab6.q1.FNameException;;

public class FullName {

	public static void main(String[] args) {
		String fname;
		Scanner sc = new Scanner(System.in);
		fname = sc.next();
		String lname;
		lname = sc.next();
		try{
		validateFname(fname);
		}
		catch(FNameException e)
		{
			System.out.println(e.getMessage());
		}
		try
		{
		validateLname(lname);
		}
		catch(FNameException e)
		{
			System.out.println(e.getMessage());
		}
	}
	static void validateFname(String fname) throws FNameException
	{
		if(fname=="")
		{
			throw new FNameException("First Name Can't be empty");
		}
		System.out.println(fname);
	}
	static void validateLname(String lname) throws FNameException
	{
		if(lname=="")
		{
			throw new FNameException("Second Name Can't be empty");
		}
		System.out.println(lname);
	}
}

