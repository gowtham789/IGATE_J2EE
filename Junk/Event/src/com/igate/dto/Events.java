package com.igate.dto;

public class Events 
{

	
	int eventid;
	String eventname;
	String eventtype;
	String location;
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getEventtype() {
		return eventtype;
	}
	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Events(int eventid, String eventname, String eventtype,
			String location) {
		super();
		this.eventid = eventid;
		this.eventname = eventname;
		this.eventtype = eventtype;
		this.location = location;
	}
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Events [eventid=" + eventid + ", eventname=" + eventname
				+ ", eventtype=" + eventtype + ", location=" + location + "]";
	}
	
	
	
	
	
	
}
