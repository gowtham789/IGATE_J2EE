package com.igate.comparator;

import java.util.ArrayList;
import java.util.Collections;

public class StudentMain {

	public static void main(String[] args) {
		
	    Student s1=new Student(101,"Lavanya",90,80,77);
	    Student s2=new Student(877,"Zameer",76,82,70);
	    Student s3=new Student(456,"Kunal",34,44,42);
	    Student s4=new Student(101,"Sruthi",63,83,81);
	    Student s5=new Student(101,"Akshay",77,88,90);
	    
	    ArrayList<Student> students=new ArrayList<Student>();
	    students.add(s1);
	    students.add(s2);
	    students.add(s3);
	    students.add(s4);
	    students.add(s5);
	    
	    System.out.println("Before Sorting");
	    
	    for(Student s:students)
	    {
	    	System.out.println("["+s+"]");
	    }
	    
	    StudentSorter ssorter=new StudentSorter();
	    
	    
	    
	    Collections.sort(students,ssorter);
	    

	    System.out.println("After Sorting");
	    
	    for(Student s:students)
	    {
	    	System.out.println("["+s+"]");
	    }
	}

}
