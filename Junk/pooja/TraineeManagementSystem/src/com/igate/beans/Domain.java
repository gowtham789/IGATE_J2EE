package com.igate.beans;

public class Domain {

	private String domain;

	public Domain() {
		super();
		
	}

	public Domain(String domain) {
		super();
		this.domain = domain;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return domain;
	}
	
}
