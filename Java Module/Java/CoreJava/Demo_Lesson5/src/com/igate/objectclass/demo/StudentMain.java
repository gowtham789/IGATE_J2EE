package com.igate.objectclass.demo;

public class StudentMain {

	public static void main(String[] args) {
		Student s1=new Student();
		s1.setStuId(101);
		s1.setName("Anu");
		s1.setAge(22);

		Student s2=new Student();
		s2.setStuId(102);
		s2.setName("Abi");
		s2.setAge(27);
		
		System.out.println(s1.getClass());
		System.out.println("Hashcode");
		System.out.println("s1 = " +s1.hashCode());
		System.out.println("s2 = "+s2.hashCode());
		
		Student s3=s2;
		System.out.println("s3 = "+s3.hashCode());
		s3.setAge(42);
		
		System.out.println("After seeting age in s3 as 42...");
		System.out.println("s3 = " +s3.hashCode());
		System.out.println("s2 = "+s2.hashCode());
		
		System.out.println("s2 age is "+s2.getAge());
		System.out.println("s3 age is "+s3.getAge());
		
	}

}
