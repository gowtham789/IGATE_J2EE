package com.igate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("c1")
public class Customer {

	@Value("Shiv")
	private String cname;
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Value("Mumbai")
	private String loc;
}
