package com.cg.lab3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.igate.lab.dto.PersonDTO;

public class AgeFullName7 {
	
	 void calculateAge(String s)
	 {
		 PersonDTO p1=new PersonDTO();
		 p1.setDob(s);
		 String dob=p1.getDob();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	     LocalDate enteredDate = LocalDate.parse(dob,formatter);
         LocalDate end = LocalDate.now();
		 Period period = enteredDate.until(end);
		 System.out.println("Age of the person is "+ period.getYears());
	 }
	  void getFullName(String a,String b)
	 {
		  
		  PersonDTO p=new PersonDTO();
		  p.setFirstName(a);
		  p.setLastName(b);
		  System.out.println("Name of the person is "+p.getFirstName()+"  "+p.getLastName());
	 }
	 
	
 public static void main(String args[])
 {
    
	PersonDTO p=new PersonDTO();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter First Name of the person");
	String s=sc.next();
	System.out.println("Enter Last Name of the person");
	String s1=sc.next();
	System.out.println("Enter Date of birth of the person");
	String s3=sc.next();
	
	
	System.out.println("Enter Gender of the person");
	String s2=sc.next();
	char gen=s2.charAt(0);
	p.setGender(gen);
	
	System.out.println("Enter Phoneno of the Person");
	String s4=sc.next();
	p.setPhnno(s4);
	
	System.out.println("******PERSON DETAILS********");

	
	
	//calling Full name function
	AgeFullName7 age=new AgeFullName7();
	age.getFullName(s,s1);
	
	//Calling age function
	AgeFullName7 dob=new AgeFullName7();//
	dob.calculateAge(s3);
	System.out.println("Gender is "+p.getGender());
	System.out.println("phone no is"+p.getPhnno());
	
	System.out.println("****************************");
      
	sc.close();
 }

}
