package com.cg.mps.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cg.mps.dto.MobileDTO;
import com.cg.mps.dto.PurchaseDTO;
import com.cg.mps.exception.MobileException;
import com.cg.mps.service.MobileService;


public class MobileMain 
{
	public static void main(String[] args)
	{
		MobileService ms=new MobileService();
		Scanner sc=new Scanner(System.in);
		
		int choice;
		
		while(true)
		{
			System.out.println("Welcome to Mobile Purchase System");
			//System.out.println(" 1 -> Insert Mobile details");
			System.out.println(" 1 -> Insert Purchase details");
			System.out.println(" 2 -> Update the mobile quantity ");
			System.out.println(" 3 -> View Details of all mobiles ");
			System.out.println(" 4 -> Delete a mobile");
			System.out.println(" 5 -> Search a mobile");
			System.out.println(" 6 -> Exit");
			
			System.out.println(" ---------------------");
			System.out.println(" Enter your choice :");
			choice=sc.nextInt();	
			switch(choice)
			{
			case 1:
			{
				//Inserting Purchase Details
				// Create sequence purchaseId_seq Start with 1000;
				
				PurchaseDTO p=new PurchaseDTO();
				
			
				
				//validating name
				
				String namePattern = "[A-Z][a-z]+";
				while (true) {
					System.out.println("Enter the Customer Name");
					String nameTemp = sc.next();

					if (Pattern.matches(namePattern, nameTemp)) {
						p.setCname(nameTemp);
						break;
					} else {
						System.err.println("Please provide valid name");
					}
				}
				
				//validating email
				
				String emailPattern="[A-Za-z0-9]+@[a-z]+.com";
				while (true) {
					System.out.println("Enter the mail id ");
					String emailTemp = sc.next();

					if (Pattern.matches(emailPattern, emailTemp)) {
						p.setMailId(emailTemp);
						break;
					} else {
						System.err.println("Please provide valid email address");
					}
				}
				
				//validating phoneno
				
				String phnPattern="[9/8][0-9]{9}";
				while (true) {
					System.out.println("Enter the phone number ");
					String phnTemp = sc.next();

					if (Pattern.matches(phnPattern, phnTemp)) {
						p.setPhnNo(phnTemp);
						break;
					} else {
						System.err.println("Please provide valid phone number");
					}
				}
				
				//validating mobile id
				
				while(true)
				{
					System.out.println("Enter the mobileId :");
					int mobId=sc.nextInt();
					if(mobId>999 && mobId <10000)
					{
							try
							{
								if(ms.isMobile(mobId)==true)
								{
									p.setMobileId(mobId);
									break;
								}	
								else
								{
									System.out.println("No mobile id found");
								}
							}
							catch(MobileException me)
							{
								System.out.println(me.getMessage());
							}
					
						
					}
					else
					{
						System.err.println("Mobile id should be 4 digits only");
					}
					
				
				}
				try
				{
				//Call the service layer to insert the purchase details
				int purId=ms.insertCustdetails(p);
				if(purId!=0)
				{
					System.out.println("Customer Inserted Successfully Id is : "+purId);
				}
				else
				{
					System.out.println("Sorry! Unable to insert the details");
				}
				}
				catch(MobileException me)
				{
					System.out.println(me.getMessage());
				}
				break;
			}//End of Case 1

			case 2:
				
				//Updating the mobile quantity
				System.out.println("Updating Mobiles");
				
				   try
					{
					//Call the service layer to insert the purchase details
					int count=ms.updateMobile();
					if(count>0)
					{
						System.out.println("Updation successfull");
						System.out.println("No of rows updated are"+count);
					}
					}
					catch(MobileException me)
					{
						System.out.println(me.getMessage());
					}
					
				
				
				
				break;
				
				
			case 3:
				//Getting all Mobiles details
				System.out.println("Displaying all Mobiles");
				ArrayList<MobileDTO> mobList= new ArrayList<MobileDTO>();
				 try
				 {
				
					 mobList=ms.getAllDetails();
					 if(mobList.size()==0)
					 {
					 System.out.println("Sorry! No Mobiles found...");
					 }
					 else
					 {
						 System.out.println("    Mobile Details     ");
						 System.out.println("-----------------------");
						 System.out.println("Id   Name    Price   Quantity");
						 
						 for(MobileDTO b:mobList)
						 {
							 System.out.println(b.getMobId()+"  "+b.getName()+" "+b.getPrice()+" "+b.getQuantity());
						 }
						 System.out.println(" ");
						 System.out.println("-----------------------");
					 }
				 
				 }catch(MobileException me)
					{
						System.out.println(me.getMessage());
					}
			
				
				break;//end of case 3
				
			case 4:
				MobileDTO m=new MobileDTO();
				System.out.println("Enter the mobile id to delete");
			    int id=sc.nextInt();
			    m.setMobId(id);
			    try
				{
				//Call the service layer to insert the purchase details
				int count=ms.deleteMobile(id);
				if(count>0)
				{
					System.out.println("deletion is successfull id is"+id);
				}
				else
				{
					System.out.println("sorry deletion is unsuccessful");
				}
				}
				catch(MobileException me)
				{
					System.out.println(me.getMessage());
				}
				
				
				break;
		
			case 5:
				
				System.out.println("Searching a product");
				System.out.println("Enter the minimum cost of mobile");
				int min=sc.nextInt();
				System.out.println("Enter the maximum cost of mobile");
				int max=sc.nextInt();
				
				ArrayList<MobileDTO> mobList1= new ArrayList<MobileDTO>();
				 try
				 {
				
					 mobList1=ms.getMobileByRange(min,max);
					 if(mobList1.size()==0)
					 {
					 System.out.println("Sorry! No Mobiles found...");
					 }
					 else
					 {
						 System.out.println("    Mobile Details     ");
						 System.out.println("-----------------------");
						 System.out.println("Id   Name    Price   Quantity");
						 
						 for(MobileDTO b:mobList1)
						 {
							 System.out.println(b.getMobId()+"  "+b.getName()+" "+b.getPrice()+" "+b.getQuantity());
						 }
						 System.out.println(" ");
						 System.out.println("-----------------------");
					 }
				 
				 }catch(MobileException me)
					{
						System.out.println(me.getMessage());
					}
			
				
				
				/*try {
					int count=ms.getMobileByRange(min, max);
					System.out.println("Number of mobiles fetched are"+count);
				} catch (MobileException me) {
					// TODO Auto-generated catch block
					System.out.println(me.getMessage());
				}
				*/
				break;
			case 6:
				System.exit(0);
				break;
			
			
	  }

    }
  }
}
