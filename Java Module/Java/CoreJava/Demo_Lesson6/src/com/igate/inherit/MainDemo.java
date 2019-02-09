package com.igate.inherit;

public class MainDemo {

	public static void main(String[] args) {
		Person p1=new Person("Arun",30);
		System.out.println(p1);
		
		Student s1=new Student();
		System.out.println(s1);
		s1.display();
		
		Student s2=new Student("Tarun",22,88,101);
		System.out.println(s2);
		
		System.out.println(" s1 instance of Student ? "+(s1 instanceof Student));
		System.out.println(" s1 instance of Person ? "+(s1 instanceof Person));

		
		System.out.println(" p1 instance of Student ? "+(p1 instanceof Student));
		System.out.println(" p1 instance of Person ? "+(p1 instanceof Person));
	}
}
