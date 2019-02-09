package com.cg.ep.main;

import java.util.ArrayList;
import java.util.Scanner;


import com.cg.ep.dto.ExecutiveDTO;
import com.cg.ep.exception.ExecutiveException;
import com.cg.ep.service.ExecutiveService;

public class ExecutiveMain 
{
public static void main(String args[]) throws ExecutiveException
{
	ExecutiveService es=new ExecutiveService();
	Scanner sc=new Scanner(System.in);
	ExecutiveDTO edto=new ExecutiveDTO();
	
	int choice;
	
	
	
	System.out.println("Welcome to Airline Reservation System");
	System.out.println(" 1 -> View Occupancy for given period");
	System.out.println(" 2 -> View Occupancy by departure and arrival city");
	System.out.println(" 3 -> Exit");
	System.out.println(" ---------------------");
	System.out.println(" Enter your choice :");
	choice=sc.nextInt();
	
	
	switch(choice)
	{
	case 1:
	{
		System.out.println("Enter departure time");
		String dtime=sc.next();
		
		System.out.println("Enter arrival time");
		String atime=sc.next();
		
		System.out.println("Enter the flight id to get the occupancy of that flight");
		String id=sc.next();
		boolean isDtime;
		boolean isAtime;
		boolean isValid;
		//isAtime=es.isArrtime(atime);
		isValid=es.isFlightNo(id);
		//isDtime=es.isDeptime(dtime);
		 
		
		try
		{
			isValid=es.isFlightNo(id);

			//If project is Valid
			if(isValid)
			{
				edto=es.viewById(id);
				System.out.println("FIRST_SEATS    BUSS_SEATS  ");
				System.out.println(edto.getFirst_seats()+"	      "+edto.getBuss_seats());
			}
			else
			{
				System.out.println("Sorry ! Invalid flight id...");
			}

		}
		catch(ExecutiveException be)
		{
			System.out.println(be.getMessage());
		}
		
		
		
		
		
		try
		{
			isAtime=es.isArrtime(atime);

			//If project is Valid
			if(isAtime)
			{
				edto=es.viewByAtime(atime);
				//System.out.println("Project_Code   Project_name    Duration   No_of_Resources	Start_Date");
				//System.out.println(p.getProjectCode()+"	      "+p.getProjectName()+" 	 "+p.getDuration()+"		"+p.getNoOfResources()+" 		"+p.getStartDate());
			}
			else
			{
				System.out.println("Sorry ! Invalid arrival time...");
			}

		}
		catch(ExecutiveException be)
		{
			System.out.println(be.getMessage());
		}
		
		
		
		try
		{
			isDtime=es.isDeptime(dtime);

			//If project is Valid
			if(isDtime)
			{
				edto=es.viewByDtime(dtime);
				//System.out.println("Project_Code   Project_name    Duration   No_of_Resources	Start_Date");
				//System.out.println(p.getProjectCode()+"	      "+p.getProjectName()+" 	 "+p.getDuration()+"		"+p.getNoOfResources()+" 		"+p.getStartDate());
			}
			else
			{
				System.out.println("Sorry ! Invalid departure time...");
			}

		}
		catch(ExecutiveException be)
		{
			System.out.println(be.getMessage());
		}
		
		
		/*try
		{
			
			
			 
			 
			 if(isDtime)

			 {
				 
				 ExecutiveDTO d=es.viewByDtime(dtime);
				 System.out.println(d);
			 
				if(isDtime==false)
				 {
					 
					 System.out.println("Sorry....!!Invalid departure time");
				 }
				 
				 
				 if(isAtime)

				 {
					 
					 ExecutiveDTO a=es.viewByAtime(atime);
					 System.out.println(a);
				 }
				 else if(isAtime==false)
				 {
					 
					 System.out.println("Sorry....!!Invalid arrival time");
				 }
				 
				 
				 if(isValid)

				 {
					 
					 ExecutiveDTO i=es.viewById(id);
					 System.out.println(i);
				 }
				 else
				 {
					System.out.println("Sorry....!!Invalid flight id");
				 
			 }
			 }
		}
			 	 
			
		 catch(ExecutiveException be)
		{
			System.out.println(be.getMessage());
		}*/
		
	 break;
	}
	 
	
	
	
	case 2:
	{
	//Get all flight details
		System.out.println("Displaying all Flights based on departure and arrival city");
		System.out.println("Enter departure city :");
		String dcity=sc.next();
		boolean isDcity;
		
		isDcity=es.isDepcity(dcity);
		try
		{
			isDcity=es.isDepcity(dcity);

			//If project is Valid
			if(isDcity)
			{
				edto=es.viewDepcity(dcity);
				System.out.println("FIRST_SEATS    BUSS_SEATS  ");
				System.out.println(edto.getFirst_seats()+"	      "+edto.getBuss_seats());
			}
			else
			{
				System.out.println("Sorry ! Invalid flight id...");
			}

		}
		catch(ExecutiveException be)
		{
			System.out.println(be.getMessage());
		}
		
		ArrayList<ExecutiveDTO> airlineList= new ArrayList<ExecutiveDTO>();
		 try
		 {
		
			 airlineList=es.viewAllFlights();
			 if(airlineList.size()==0)
			 {
			 System.out.println("Sorry! No flights found...");
			 }
			 else
			 {
				 System.out.println("    Flight Details     ");
				 System.out.println("-----------------------");
				 System.out.println("code   Name   Duration   No of resources  Start date");
				 
				 for(ExecutiveDTO e:airlineList)
				 {
					 System.out.println(e.getFlight_no()+"  "+e.getAirline()+" "+e.getDep_city()+" "+e.getArr_city()+" "+e.getDep_day()+" "+e.getArr_day()+" "+e.getDep_time()+" "+e.getArr_time()+" "+e.getFirst_seats()+" "+e.getFirst_seat_fare()+" "+e.getBuss_seats()+" "+e.getBuss_seat_fare());
				 }
				 System.out.println(" ");
				 System.out.println("-----------------------");
			 }
		 
		 }//END OF TRY
		 
		 catch(ExecutiveException ee)
			{
				System.out.println(ee.getMessage());
			}
	 break;
	}//END OF CASE2
	 
	 
	case 3:
	{
		System.exit(0);
	}
}
}
}
