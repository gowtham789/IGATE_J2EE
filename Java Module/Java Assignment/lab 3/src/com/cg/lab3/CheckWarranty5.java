package com.cg.lab3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CheckWarranty5 {

	public static void main(String[] args) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	//to accept input from user
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter the purchase date in dd/MM/yyyy format");
	String  purchase=sc.nextLine();
	
	LocalDate purchaseDate=LocalDate.parse(purchase,formatter);
	System.out.println("Enter the warranty period:");
	System.out.println("Years:");
	int year=sc.nextInt();
	System.out.println("Months");
	int month=sc.nextInt();
	
    LocalDate expDate=purchaseDate.plusMonths(month).plusYears(year); //expiry date calculation
    System.out.println("Warranty of product expires on:"+expDate);  
	sc.close();
	
	}

}
