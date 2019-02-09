package com.cg.reg.dto;

public class RegisterDto {
	
	String fname;
	String lname;
	String password;
	String gender;
	String skills;
	String city;
	public RegisterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterDto(String fname, String lname, String password,
			String gender, String skills, String city) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.gender = gender;
		this.skills = skills;
		this.city = city;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "RegisterDto [fname=" + fname + ", lname=" + lname
				+ ", password=" + password + ", gender=" + gender + ", skills="
				+ skills + ", city=" + city + "]";
	}
	
	

}
