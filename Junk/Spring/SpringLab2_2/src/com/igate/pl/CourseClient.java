package com.igate.pl;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igate.bean.Course;
import com.igate.service.CourseServiceIntf;



public class CourseClient {

	public static void main(String[] args) 
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		CourseServiceIntf ui = (CourseServiceIntf) ctx.getBean("courseService");
		
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println(" 1 -> Get course By Id");
		System.out.println(" 2 -> Get all courses ");
		System.out.println(" 3 -> Add a course");
		System.out.println(" 4 -> Remove a course");
		System.out.println(" 5 -> Update Course");
		System.out.println(" 6 -> Exit");
				
		System.out.println(" ---------------------");
		System.out.println(" Enter your choice :");
		Course c=new Course();
		int choice=sc.nextInt();	
		switch(choice)
		{
		case 1:
			
			System.out.println("Enter the course number/id");
			int cid=sc.nextInt();
			Course c1=ui.getCourse(cid);
			System.out.println(c1);
			break;
		case 2:
			
			List<Course> l = ui.getAllCourses();
			for (Course u : l)
			{
				System.out.println("*****************Course Details*****************");
				System.out.println("Course Id   Course Name  Course Duration");
				System.out.println(u.getCourseId()+"        "+u.getCourseName()+"         "+u.getDuration());
			}
			
		case 3:
			
			System.out.println("Enter the Course Id");
			int id= sc.nextInt();
			c.setCourseId(id);
			System.out.println("Enter the Course Name");
			String name= sc.next();
			c.setCourseName(name);
			System.out.println("Enter the Course Duration");
			int d= sc.nextInt();
			c.setDuration(d);
			
			int count=ui.addCourse(c);
			if(count>0)
			{
				System.out.println("Course details inserted successfully");
			}
			else
			{
				System.out.println("Course details insertion failed");
			}
			
			break;
			
		case 4:
			System.out.println("Enter the Course Id to remove");
			int id1= sc.nextInt();
			int delcourse=ui.removeCourse(id1);
			if(delcourse>0)
			{
				System.out.println("Course details deleted successfully");
			}
			else
			{
				System.out.println("Course details deletion failed");
			}
			
			break;
		
		case 5:
			
			System.out.println("Enter the Course Id");
			int id2= sc.nextInt();
			Course c2=new Course();
			c2.setCourseId(id2);
			System.out.println("Enter the Course Name");
			String name2= sc.next();
			c2.setCourseName(name2);
			System.out.println("Enter the Course Duration");
			int d2= sc.nextInt();
			c2.setDuration(d2);
			int updateStatus=ui.updateCourse(c2);
			if(updateStatus>0)
			{
				System.out.println("Course details updated successfully");
			}
			else
			{
				System.out.println("Course details updation failed");
			}
			
			break;
			
			

			
		}
		
		
	}

}
