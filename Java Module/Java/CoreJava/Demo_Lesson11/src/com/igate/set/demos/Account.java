package com.igate.set.demos;

public class Account {

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", balance=" + balance
				+ ", custName=" + custName + "]";
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accId, float balance, String custName) {
		super();
		this.accId = accId;
		this.balance = balance;
		this.custName = custName;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	int accId;
	float balance;
	String custName;
	
}
