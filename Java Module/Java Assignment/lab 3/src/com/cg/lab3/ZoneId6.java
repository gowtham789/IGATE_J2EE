package com.cg.lab3;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class ZoneId6 {

	public static void main(String[] args) {
	
		System.out.println("Select a time Zone ");
		System.out.println("1.NewYork");
		System.out.println("2.London");
		System.out.println("3.Asia");
		System.out.println("4.US");
		System.out.println("5.Africa");
		System.out.println("6.Austalia");
		System.out.println("Enter the choice");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		switch (choice)
		{
		case 1:
			ZonedDateTime currentTimeInNewYork = ZonedDateTime.now(ZoneId.of("America/New_york"));
			 
			System.out.println("America/New_York:"+ currentTimeInNewYork);
			
			break;
		case 2:
			ZonedDateTime currentTimeInLondon = ZonedDateTime.now(ZoneId.of("Europe/London"));
			System.out.println("Europe/London:"+ currentTimeInLondon);
			break;
		case 3:
			ZonedDateTime currentTimeInAsia = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
			System.out.println("Asia/Tokyo:"+ currentTimeInAsia);
			break;
		case 4:
			ZonedDateTime currentTimeInUS = ZonedDateTime.now(ZoneId.of("US/Pacific"));
			System.out.println("US/Pacific:"+ currentTimeInUS);
			break;
		case 5:
			ZonedDateTime currentTimeInAfrica = ZonedDateTime.now(ZoneId.of("Africa/Cairo"));
			System.out.println("Africa/Cairo:"+ currentTimeInAfrica);
			break;
		case 6:
			ZonedDateTime currentTimeInAustralia =ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
			System.out.println("Australia/Sydney:"+ currentTimeInAustralia);
			break;
        

		default:
			System.out.println("Please enter the valid choice ");
			break;
		}
		
		

	
		sc.close();

	}

}
