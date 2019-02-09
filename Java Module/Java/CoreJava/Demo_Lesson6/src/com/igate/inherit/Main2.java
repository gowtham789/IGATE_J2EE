package com.igate.inherit;

public class Main2 {

	public static void main(String[] args) {
	Person p1 = new Student();
		System.out.println(p1);
		p1.display();

		System.out.println(" p1 instance of Student ? "
				+ (p1 instanceof Student));
		System.out
				.println(" p1 instance of Person ? " + (p1 instanceof Person));

		Student s2 = (Student) p1;
		System.out.println(s2);

		Person p2 = p1;
		System.out.println(p2);

		//Employee demo
		
		//Create employee object and store in person object - works
		Employee e1 = new Employee();
		System.out.println(e1);
		
		Person p3=e1;
		p3.display();
		
		//Create person object and store in employee object - does not work
		Person p4=new Person();
		Employee e2=(Employee) p4;
		e2.display();
		

	}

}
