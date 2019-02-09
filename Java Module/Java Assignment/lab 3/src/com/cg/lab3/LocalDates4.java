package com.cg.lab3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LocalDates4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter date1 in dd/MM/yyyy format:");
		String input  = scanner.nextLine();
		System.out.print("Enter date2 in dd/MM/yyyy format:");
		String input1  = scanner.nextLine();
		LocalDate enteredDate1= LocalDate.parse(input,formatter);
		LocalDate enteredDate2= LocalDate.parse(input1,formatter);
		Period period = enteredDate1.until(enteredDate2);
		System.out.println("Days:"+ period.getDays());
		System.out.println("Months:"+period.getMonths());
		System.out.println("Years:"+ period.getYears());
		scanner.close();

	}

}
