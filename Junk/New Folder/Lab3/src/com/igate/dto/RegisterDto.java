package com.igate.dto;

public class RegisterDto {

	private String fName;
	private String lName;
	private String pwd;
	private String gender;
	private String skill;
	private String city;
	
	//getter and setter
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public RegisterDto(String fName, String lName, String pwd, String gender,
			String skill, String city) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.pwd = pwd;
		this.gender = gender;
		this.skill = skill;
		this.city = city;
	}
	
	public RegisterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "RegisterDto [fName=" + fName + ", lName=" + lName + ", pwd="
				+ pwd + ", gender=" + gender + ", skill=" + skill + ", city="
				+ city + "]";
	}	
}
