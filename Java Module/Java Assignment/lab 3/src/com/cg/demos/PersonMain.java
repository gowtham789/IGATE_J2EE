
//Lab program 2.3 and 2.4
package com.cg.demos;

public class PersonMain {
	
	
	//display function 
	public void display(Person p) 
	{
		System.out.println("Person Details:");
		   System.out.println("---------------------------------");
		   System.out.println("First Name:"+p.getFirstName());
		   System.out.println("Last Name:"+p.getLastName());
		   System.out.println("Gender:"+p.getGender());
		   System.out.println("Phone No:"+p.getPhnno());
		
		   
	    System.out.println("---------------------------------");
	}

	public static void main(String[] args) {
		
		
		
		Person p1=new Person(); //Default Construtor Calling
		p1.setFirstName("Gowtham");
		p1.setLastName("Guntoju");
		p1.setGender('M');
		p1.setPhnno("9000156252");
	
		
		System.out.println("Person Details 1:");
		   System.out.println("---------------------------------");
		   System.out.println("First Name:"+p1.getFirstName());
		   System.out.println("Last Name:"+p1.getLastName());
		   System.out.println("Gender:"+p1.getGender());
		   System.out.println("Phone No:"+p1.getPhnno());
	    System.out.println("---------------------------------");
	    
	    Person p2=new Person("Kishan","Siggu",'M',"9565645428"); //Parameterised Constructor Calling
	    
		System.out.println("Person Details 2:");
		   System.out.println("---------------------------------");
		   System.out.println("First Name:"+p2.getFirstName());
		   System.out.println("Last Name:"+p2.getLastName());
		   System.out.println("Gender:"+p2.getGender());
		   System.out.println("Phone No:"+p2.getPhnno());
	    System.out.println("---------------------------------");
	    
	    //2.4 calling through display function
	    Person p3=new Person(); 
	    p3.setFirstName("Venky");
		p3.setLastName("Narsingh");
		p3.setGender('M');
		p3.setPhnno("9154512154");
		
		PersonMain personMain=new PersonMain();
		personMain.display(p3); 
	    
	    
	}

}
