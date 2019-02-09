package com.igate.tms.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class Trainee 
{
	private int id;
	@NotEmpty(message=" Name is mandatory")
	@Size(min=4,max=8,message="Minimum 4 and Maximum 8 characters required")
	private String name;
	@NotEmpty(message=" location is mandatory")
	private String location;
	@NotEmpty(message=" Name is mandatory")
	private String domain;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
}
