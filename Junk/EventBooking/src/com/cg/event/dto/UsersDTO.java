package com.cg.event.dto;

public class UsersDTO {

	
	String name;
	String eventtype;
	int numofseats;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEventtype() {
		return eventtype;
	}
	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}
	public int getNumofseats() {
		return numofseats;
	}
	public void setNumofseats(int numofseats) {
		this.numofseats = numofseats;
	}
	public UsersDTO(String name, String eventtype, int numofseats) {
		super();
		this.name = name;
		this.eventtype = eventtype;
		this.numofseats = numofseats;
	}
	public UsersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "users [name=" + name + ", eventtype=" + eventtype
				+ ", numofseats=" + numofseats + "]";
	}
	
	
	
	
	
	
}
