package com.capgemini.Lab4.q2;
import com.capgemini.Lab4.q1.*;
public class CurrentAccount extends Account{
	private static final double overDraftLimit = 15000;
	private double balance;
	public CurrentAccount()
	{
		this.balance = super.getBalance();
	}
	public void withDraw(double bal)
	{
		if(bal>overDraftLimit)
		{
			System.out.println("Withdraw can't be possible due to overdraft");
		}
		else
		{
			this.balance=balance-bal;
		}
	}
}
