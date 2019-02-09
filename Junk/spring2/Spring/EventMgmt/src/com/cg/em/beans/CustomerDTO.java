package com.cg.em.beans;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class CustomerDTO {

	@NotEmpty(message="Enter Valid Name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Username must contain only alphabets")
	private String name;
	
	@NotEmpty(message="Enter Valid Name")
	private String eventType;
	private int seats;
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDTO(String name, String eventType, int seats) {
		super();
		this.name = name;
		this.eventType = eventType;
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "CustomerDTO [name=" + name + ", eventType=" + eventType
				+ ", seats=" + seats + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}

	
	
}
