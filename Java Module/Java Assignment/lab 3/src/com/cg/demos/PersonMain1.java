
//Lab program 2.4
package com.cg.demos;

import com.cg.demos.Person.Gender;

public class PersonMain1 {
	
	
	public static void main(String[] args) {
		
		
		
		Person p1=new Person(); //Default Construtor Calling
		p1.setFirstName("Gowtham");
		p1.setLastName("Guntoju");
		
		p1.setPhnno("9000156252");
		p1.gen=Gender.M;
		
		System.out.println("Person Details 1:");
		   System.out.println("---------------------------------");
		   System.out.println("First Name:"+p1.getFirstName());
		   System.out.println("Last Name:"+p1.getLastName());
		   System.out.println("Gender:"+p1.gen);
		   System.out.println("Phone No:"+p1.getPhnno());
	    System.out.println("---------------------------------");
	    
	   	}

}
