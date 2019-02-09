

public class SavingsAccount extends Account{
	private static final double minBal = 500;
	private double balance;
	public SavingsAccount()
	{
		this.balance = super.getBalance();
		
	}
	@Override
	public void withDraw(double bal)
	{
		Double amnt = this.balance-bal;
		if(amnt <= minBal)
		{
			System.out.println("Withdraw can't be possible(Savings account)");
		}
		else
		{
			this.balance=balance-bal;
		}
	}
}
