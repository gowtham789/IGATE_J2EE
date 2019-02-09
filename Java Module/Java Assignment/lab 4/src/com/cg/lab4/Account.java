package com.cg.lab4;

public class Account 
{
	long accNum;
	private double balance;
	private Person accHolder;
	public long getAccNum() {
		return accNum;
	}
	public Person getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void deposit(double bal)
	{
		this.balance = balance+bal;
		
	}
	public void withDraw(double bal)
	{
		Double bala = this.balance-bal;
		if(bala<=500)
		{
			System.out.println("Can't withdraw amount");
		}
		else
			this.balance = balance-bal;
	}
	public Account()
	{
	
	}
	public Account(Person acntHldr, double balance)
	{
		
		this.accHolder = acntHldr;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", balance=" + balance
				+ ", accHolder=" + accHolder + "]";
	}

}
