package com.cg.em.beans;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class EventDTO {

	private int eventId;
	
	@NotEmpty(message="Enter Valid Name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Username must contain only alphabets")
	private String eventname;
	
	@NotEmpty(message="Enter Valid Name")
	private String location;
	
	@NotEmpty(message="Enter Valid Name")
	private String eventType;
	public EventDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventDTO(int eventId, String eventname, String location,
			String eventType) {
		super();
		this.eventId = eventId;
		this.eventname = eventname;
		this.location = location;
		this.eventType = eventType;
	}
	@Override
	public String toString() {
		return "EventDTO [eventId=" + eventId + ", eventname=" + eventname
				+ ", location=" + location + ", eventType=" + eventType + "]";
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	
	
}
