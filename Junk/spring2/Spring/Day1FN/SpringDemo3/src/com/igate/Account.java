package com.igate;

public class Account {

	

	String accId;
	float balance;
	int noOfYears;
	Customer c1;
	
	public String getAccId() {
		return accId;
	}
	public void setAccId(String accId) {
		this.accId = accId;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getNoOfYears() {
		return noOfYears;
	}
	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}
	
	public Customer getC1() {
		return c1;
	}
	public void setC1(Customer c1) {
		this.c1 = c1;
	}
	
	public void calculateInterest()
	{
		float roi=9.5f;
		float interest=balance*noOfYears*roi/100;
		
		System.out.println(" Account id        : "+accId);
		System.out.println(" Customer Name     : "+c1.getCname());
		System.out.println(" Customer Location : "+c1.getLoc());
		System.out.println(" Balance           : "+balance);
		
		System.out.println("******************************");
		System.out.println(" Interest         : "+interest);
	}
}
