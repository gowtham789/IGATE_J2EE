package com.cg.lab3;


public class PersonDTO {
	private String firstName;
	private String LastName;
	private char gender;
	private String phnno;

	public PersonDTO()
	{
		this.firstName=firstName;
		this.LastName=LastName;
		this.gender=gender;
		this.phnno=phnno;
	}
	
	public PersonDTO(String firstName, String LastName, char gender,String phnno) {
		
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

	@Override
	public String toString() {
		return "PersonDTO [firstName=" + firstName + ", LastName=" + LastName
				+ ", gender=" + gender + ", phnno=" + phnno + "]";
	}



	
	
 }
