package com.cg.emp.dto;

public class Employee 
{
	private int eid;
	private String ename;
	private int sal;
	
	public Employee() {
		super();
	}
	
	public Employee(int eid, String ename, int sal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
	}

	public int getEid() {
		return eid;
	}
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public int getSal() {
		return sal;
	}
	
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", sal=" + sal
				+ "]";
	}
	
}
