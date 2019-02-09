package com.cg.pms.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cg.pms.dto.ProjectDTO;
import com.cg.pms.exception.ProjectException;
import com.cg.pms.service.ProjectService;

public class ProjectMain
{
   public static void main(String[] args)
	{
		ProjectService ps=new ProjectService();
		Scanner sc=new Scanner(System.in);
		
		int choice;
		
		while(true)
		{
			System.out.println("Welcome to Project Management System");
			
			System.out.println(" 1 -> Insert project details");
			System.out.println(" 2 -> View Details of particular project ");
			System.out.println(" 3 -> View Details of all projects ");
			System.out.println(" 4 -> Delete a project");
			System.out.println(" 5 -> Exit");
			
			System.out.println(" ---------------------");
			System.out.println(" Enter your choice :");
			choice=sc.nextInt();	
			
			switch(choice)
			{	
	
			case 1:
			
		
			//Inserting Project Details
			// Create sequence project_sequence Start with 1000;
			
			ProjectDTO p=new ProjectDTO();
			
		
			
			//validating project name
			
			String namePattern = "[A-Z][A-z]+";
			while (true) {
				System.out.println("Enter the Project Name");
				String nameTemp = sc.next();

				if (Pattern.matches(namePattern, nameTemp)) 
				{
					p.setProjectName(nameTemp);
					break;
				} 
				else 
				{
					System.err.println("Please provide valid Project name");
				}
			
			
			}
			//validating duration
			
			while(true)
			{
				System.out.println("Enter the duration of project :");
				int dur=sc.nextInt();
				if(dur>0 && dur <25)
				{
					p.setDuration(dur);
					break;
				}
				else
				{
					System.err.println("Project duration should  be between 1 to 25");
				}
				
			}
			
//validating no of resources
			
			while(true)
			{
				System.out.println("Enter the no of resources :");
				int res=sc.nextInt();
				if(res>4 && res <201)
				{
						
					p.setNoOfResources(res);
					break;
				}
				else
				{
					System.err.println("No of resources  should  be between 5 to 200");
				}
				
			}
			
			try
			{
			//Call the service layer to insert the purchase details
			int pId=ps.insertProject(p);
			if(pId!=0)
			{
				System.out.println("Project  Inserted Successfully Id is : "+pId);
			}
			else
			{
				System.out.println("Sorry! Unable to insert the details");
			}
			}
			catch(ProjectException me)
			{
				System.out.println(me.getMessage());
			}
			
			break;
			
			case 2:
				
				//Get project By Id
				System.out.println("Enter the project id  to search!");
				 int id=sc.nextInt();
				 boolean isValid;
				 try
				 {
				 isValid=ps.isProject(id);
				 
				 //If book is Valid
				 if(isValid)

				 {
					 ProjectDTO p1=ps.viewById(id);
					 System.out.println(p1);
				 }
				 else
				 {
					 System.out.println("Sorry ! Invalid Project Id...");
				 }
				 
				 }catch(ProjectException be)
					{
						System.out.println(be.getMessage());
					}
				
				break;//end of case 2
			case 3:
				
				//Get project By Id
				System.out.println("Displaying all Project Details");
				ArrayList<ProjectDTO> projectList= new ArrayList<ProjectDTO>();
				 try
				 {
				
					 projectList=ps.viewAllProjects();
					 if(projectList.size()==0)
					 {
					 System.out.println("Sorry! No Projects found...");
					 }
					 else
					 {
						 System.out.println("    Project Details     ");
						 System.out.println("-----------------------");
						 System.out.println("Id   Name    Duration  No.ofResources  startdate");
						 
						 for(ProjectDTO b:projectList)
						 {
							 System.out.println(b.getProjectCode()+"  "+b.getProjectName()+" "+b.getDuration()+" "+b.getNoOfResources()+" "+b.getStartdate());
						 }
						 System.out.println(" ");
						 System.out.println("-----------------------");
					 }
				 
				 }catch(ProjectException be)
					{
						System.out.println(be.getMessage());
					}
				
				break;//end of case 3

			case 4:
				
				System.out.println("Deletion of a project");
				System.out.println("Enter the project id to delete ");
				int pid=sc.nextInt();
				try {
					boolean stat=ps.deleteProject(pid);
					if(stat==true)
					{
						System.out.println("Deletion is successfull! Id is "+pid);
					}
					else
					{
						System.out.println("Deletion is unsuccessful :( ");
					}
				} 
				
				catch (ProjectException e) 
				{
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				break;
				
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Please select a valid option");
			
			}
		}
		
     }
}