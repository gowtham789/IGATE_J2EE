package com.cg.lab4;


	public class SavingsAccount extends Account{
		private static final double minBal = 500;
		/*private double balance;
		public SavingsAccount()
		{
		//	this.balance = super.getBalance();
			
		}*/
		@Override
		public void withDraw(double bal)
		{
			Double amnt = this.getBalance()-bal;
			if(amnt <= minBal)
			{
				System.out.println("Withdraw can't be possible(Savings account)");
			}
			else
			{
				this.setBalance(amnt);
			}
		}
	}



