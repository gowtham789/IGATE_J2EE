package com.cg.lab4;
import java.util.Random;
public class AccountMain {

	public static void main(String[] args) 
	{
		
		Account ac1=new Account();
		Account ac2=new Account();
		
		Random rand = new Random(); //random account number
		ac1.accNum  = 100000+rand.nextInt(50000);
		ac2.accNum  = 100000+rand.nextInt(50000);
		
		Person p1=new Person();
		Person p2=new Person();
		
		p1.setName("Smith");
		p1.setAge(23);
		
		p2.setName("Kathy");
		p2.setAge(28);
		
		ac1.setAccHolder(p1);
		ac1.setBalance(2000);
		ac2.setAccHolder(p2);
		ac2.setBalance(3000);
		
		System.out.println("Details of Account");

		System.out.println(ac1); //smith's account details
		System.out.println(ac2);//kathy's account details
		
		ac1.deposit(2000);//deposit 2000 to smith account
		ac2.withDraw(2000);//withdraw 2000 from kathys account
		
		System.out.println("Updated Balances in both accounts is");
		System.out.println(ac1);//smith's updated account details
		System.out.println(ac2);//kathy's updated account details
		
		
		
		

	
	}

}
