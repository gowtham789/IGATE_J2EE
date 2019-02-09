package com.igate.objectclass.demo;

public class StudentMain2 {

	public static void main(String[] args) {
		Student s1=new Student();
		s1.setStuId(101);
		s1.setName("Anu");
		s1.setAge(22);

		Student s2=new Student();
		s2.setStuId(102);
		s2.setName("Abi");
		s2.setAge(27);
		
		//Add a toString method in Student class 
		System.out.println(s1);
		System.out.println(s2);

	}

}
