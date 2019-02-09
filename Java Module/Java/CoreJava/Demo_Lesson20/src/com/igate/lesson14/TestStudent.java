package com.igate.lesson14;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;


public class TestStudent 
{
	@Test
	public void GetRollNo()
	{
		Student s = new Student(100, "Sam", "Dcosta");
		assertEquals(s.getRollNo(), 100);
	}
	@Test
	public void GetFirstName()
	{
		Student s = new Student(100, "Sam", "Dcosta");
		assertEquals(s.getFirstName(), "Sam");
	}
	@Ignore("The method is being modified")
	@Test
	public void testGetLastName()
	{
		Student s = new Student(100, "Sam", "Dcosta");
		assertEquals(s.getLastName(), "Dcosta");
	}
}