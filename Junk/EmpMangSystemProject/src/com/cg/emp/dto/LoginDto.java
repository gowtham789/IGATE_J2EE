package com.cg.emp.dto;

public class LoginDto 
{
	private String uname;
	private String password;
	
	public LoginDto() {
		super();
		
	}

	public LoginDto(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDto [uname=" + uname + ", password=" + password + "]";
	}
	
	
}
