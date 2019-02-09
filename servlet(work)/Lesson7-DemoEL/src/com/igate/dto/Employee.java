package com.igate.dto;

public class Employee {
	
	private int eid;
	private String enm;
	private double esl;
	private Dog eDog;
	
	public Employee(){}
	
	public Employee(int eid, String enm, double esl) {
		this.eid=eid;
		this.enm=enm;
		this.esl=esl;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEnm() {
		return enm;
	}
	public void setEnm(String enm) {
		this.enm = enm;
	}
	public double getEsl() {
		return esl;
	}
	public void setEsl(double esl) {
		this.esl = esl;
	}
	public Dog geteDog() {
		return eDog;
	}
	public void seteDog(Dog eDog) {
		this.eDog = eDog;
	}
	
	

}
