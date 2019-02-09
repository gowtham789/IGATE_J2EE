
import java.util.Random;
abstract public class Account{
	abstract void withDraw(double b);
	private long accNum;
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
	public Account()
	{
	
	}
	public Account(Person acntHldr, double balance)
	{
		Random rand = new Random();
		this.accNum  = 100000+rand.nextInt(50000);
		this.accHolder = acntHldr;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", balance=" + balance
				+ ", accHolder=" + accHolder + "]";
	}
}
