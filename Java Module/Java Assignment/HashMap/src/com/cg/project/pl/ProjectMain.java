package com.cg.project.pl;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.ArrayList;

import com.cg.project.bean.ProjectDto;
import com.cg.project.exception.ProjectException;
import com.cg.project.service.ProjectService;

public class ProjectMain
{
	
	public static void main(String args[])
	{
	
	ProjectService ps=new ProjectService();
	Scanner sc=new Scanner(System.in);
	
	int choice;
	
	while(true)
	{
		System.out.println("Welcome to The Project");
		System.out.println(" 1 -> Insert the Project details");
		System.out.println(" 2 -> Display Project Details by id");
		System.out.println(" 3 -> Fetch all Projects");
		System.out.println(" 4 -> Delete Project By Id");
		System.out.println(" 5 -> Fetch all Projects by hashmap");
		System.out.println(" ---------------------");
		System.out.println(" Enter your choice :");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
		{
			//Inserting a project
			// Create a sequence project_Seq Start with 1001
			
			ProjectDto project= new ProjectDto();
			
			//name validations
			String namePattern = "[A-Z][a-z]+{19}";
			while (true) 
			{
				System.out.println("Enter the Project Name :");
				String name = sc.next();

				if (Pattern.matches(namePattern, name))
				{
					project.setProjectName(name);
					break;
				} 
				else 
				{
					System.err.println("Please enter valid name starting with Caps and 20 character long:");
				}
			}
			//duration validation
			
			while (true) 
			{
				System.out.println("Enter the duration with in 24 months:");
				int duratn = sc.nextInt();


				if (duratn>0 && duratn<25)
				{
					project.setDuration(duratn);
					break;
				}
				else 
				{
					System.err.println("Please enter the correct duration:");
				}
			}										
			//resources validation
			while (true) 
			{
				System.out.println("Enter the resources:");
				int resource = sc.nextInt();


				if (resource>=4 && resource<=200)
				{
					project.setNoOfResources(resource);
					break;
				}
				else 
				{
					System.err.println("Please enter the resources between 5 to 200:");
				}
			}			
			
			try
			{
			//Call the service layer to insert the project details
			int pid=ps.insertProject(project);	
			if(pid!=0)
			{
				System.out.println("Project Inserted Successfully Id is : "+pid);
			}
			else
			{
				System.out.println("Sorry! Unable to insert the customer");
			}
			}
			catch(ProjectException be)
			{
				System.out.println(be.getMessage());
			}
			break;								
			
		}//close case 1
		case 2:
		{
			//Get project By Id
			System.out.println("Enter the project id to search!");
			 int id=sc.nextInt();
			 boolean isValid;
			 try
			 {
			 isValid=ps.isProject(id);
			 
			 //If project is Valid
			 if(isValid)

			 {
				 ProjectDto p=ps.viewById(id);
				 System.out.println(p);
			 }
			 else
			 {
				 System.out.println("Sorry ! Invalid project Id...");
			 }
			 
			 }catch(ProjectException be)
				{
					System.out.println(be.getMessage());
				}
		break;
		}//End of Case 2
		case 3:
		{
		//Get all book 
		System.out.println("Displaying all Books");
		ArrayList<ProjectDto> projList= new ArrayList<ProjectDto>();
		 try
		 {
			 projList=ps.viewAllProject();
			 if(projList.size()==0)
			 {
			 System.out.println("Sorry! No projects found...");
			 }
			 else
			 {
				 System.out.println("    project Details     ");
				 System.out.println("-----------------------");
				 System.out.println("Id   Name    		duration   resources	startdate");
				 
				 for(ProjectDto p:projList)
				 {
					 System.out.println(p.getProjectCode()+"  "+p.getProjectName()+"		 "+p.getDuration()+" 		"+p.getNoOfResources()+"		"+p.getStratDate());
				 }
				 System.out.println(" ");
				 System.out.println("-----------------------");
			 }
		 
		 }catch(ProjectException be)
			{
				System.out.println(be.getMessage());
			}
	 break;
		}//end of case 3
		case 4:
		{
			System.out.println("Enter the projectid to be deleted :");
			int pid=sc.nextInt();
			boolean isValid;
			try{
				isValid=ps.isProject(pid);
				
				//Call the service layer to delete the project details
				if(isValid){
				boolean projid=ps.deleteProject(pid);
				}
				else
				{
					System.out.println("Sorry ! Invalid project id");
				}
				
				}
				catch(ProjectException me)
				{
					System.out.println(me.getMessage());
				}
				break;
							
		}//end of case 4
		case 5:
		{
		//Get all book 
		System.out.println("Displaying all Books");
		HashMap<Integer,ProjectDto> projList= new HashMap<Integer,ProjectDto>();
		
		 try
		 {
			 projList=ps.viewAllProjectHash();
			 if(projList.size()==0)
			 {
			 System.out.println("Sorry! No projects found...");
			 }
			 else
			 {
				 System.out.println("    project Details     ");
				 System.out.println("-----------------------");
				 System.out.println("Id   Name    		duration   resources	startdate");
				 
				 Set<Integer> sets=projList.keySet();
				 for(Integer p:sets)
				 {
					 ProjectDto p1=projList.get(p);
					 System.out.println(p1.getProjectCode()+"  "+p1.getProjectName()+"		 "+p1.getDuration()+" 		"+p1.getNoOfResources()+"		"+p1.getStratDate());
				 }
				 System.out.println(" ");
				 System.out.println("-----------------------");
			 }
		 
		 }catch(ProjectException be)
			{
				System.out.println(be.getMessage());
			}
	 break;
		}//end of case 5
		case 6:{
			System.exit(0);
		}//end of case 5
		}//close switch
		
	}//while close
	
	}
}
