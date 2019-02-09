package com.igate.lab.pl;

import java.util.Scanner;

import com.igate.lab.dto.PersonDTO;

public class PersonMain {
	
	
	//display function 
	public void display(PersonDTO p) 
	{
		System.out.println("Person Details:");
		   System.out.println("---------------------------------");
		   System.out.println("First Name:"+p.getFirstName());
		   System.out.println("Last Name:"+p.getLastName());
		   System.out.println("Gender:"+p.getGender());
		   System.out.println("Phone No:"+p.getPhnno());
		
		   
	    System.out.println("---------------------------------");
	}

	public static void main(String args[]) 
	{
		
		
		
		PersonDTO p1=new PersonDTO(); //Default Construtor Calling
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter First Name of the person");
		String s=sc.next();
		p1.setFirstName(s);
		
		System.out.println("Enter Last Name of the person");
		String s1=sc.next();
		p1.setLastName(s1);
		
		System.out.println("Enter Gender of the person");
		String s2=sc.next();
		char gen=s2.charAt(0);
		p1.setGender(gen);
		
		System.out.println("Enter Phoneno of the Person");
		String s3=sc.next();
		p1.setPhnno(s3);
		
		PersonMain personMain=new PersonMain();//calling display() function
		personMain.display(p1);
		sc.close();//closing scanner class
	 }

}
