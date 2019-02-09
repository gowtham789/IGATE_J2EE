package com.cg.lab3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * This program will demonstrate on how to calculate difference between two dates
 */

public class CalculatingPeriod3 {

	public static void main(String[] args) {
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter date in dd/MM/yyyy format:");
		String input  = scanner.nextLine();
		
		//Almost every class in java.time package provides parse() method to parse the date or time
		LocalDate enteredDate = LocalDate.parse(input,formatter);
		LocalDate end = LocalDate.now();
		Period period = enteredDate.until(end);
		System.out.println("Days:"+ period.getDays());
		System.out.println("Months:"+period.getMonths());
		System.out.println("Years:"+ period.getYears());
		
	    scanner.close();
	}
}
