package com.igate.lesson22;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Location {

	@XmlAttribute
	private String city;
	@XmlElement
	private int capacity;
	@XmlElement
	private String state;
	
	public Location() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Location(String city, int capacity, String state) {
		super();
		this.city = city;
		this.capacity = capacity;
		this.state = state;
	}


	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
