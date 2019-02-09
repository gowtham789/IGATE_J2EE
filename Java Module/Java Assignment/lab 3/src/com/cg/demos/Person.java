

package com.cg.demos;


public class Person {
	private String firstName;
	private String LastName;
	private char gender;
	private String phnno;
	Gender gen; //enum 
	Person()
	{
		this.firstName=firstName;
		this.LastName=LastName;
		this.gender=gender;
		this.phnno=phnno;
	}
	public enum Gender //enum defining used in personmain1.java
	{
		M,F;
	}
	public Person(String firstName, String LastName, char gender,String phnno) {
		
		this.firstName = firstName;
	    this.LastName = LastName;
		this.gender = gender;
		this.phnno=phnno;
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPhnno() {
		return phnno;
	}

	public void setPhnno(String phnno) {
		this.phnno = phnno;
	}
	
 }
