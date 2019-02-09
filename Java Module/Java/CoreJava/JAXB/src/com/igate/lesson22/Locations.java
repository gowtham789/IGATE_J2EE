package com.igate.lesson22;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Locations {

	private Set<Location> locations=null;
	
	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}
	@XmlElement(name="location")
	public Set<Location> getLocations() {
		return locations;
	}
}
