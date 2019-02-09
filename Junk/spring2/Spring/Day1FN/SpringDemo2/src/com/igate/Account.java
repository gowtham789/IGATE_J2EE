package com.igate;

public class Account {

	String accId;
	float balance;
	int noOfYears;
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
	
	public float calculateInterest()
	{
		float roi=9.5f;
		float interest=balance*noOfYears*roi/100;
		return interest;
	}
}
