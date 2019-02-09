package com.cg.lab4;

import java.util.Random;

public class AccountMain1 {

	public static void main(String[] args) 
	{
		
		SavingsAccount sa=new SavingsAccount();
		CurrentAccount ca=new CurrentAccount();
		Random rand = new Random(); //random account number
		sa.accNum  = 100000+rand.nextInt(50000);
		ca.accNum  = 100000+rand.nextInt(50000);
		
		Person p1=new Person();
		Person p2=new Person();
		
		p1.setName("Smith");
		p1.setAge(23);
		
		p2.setName("Kathy");
		p2.setAge(28);
		
		sa.setAccHolder(p1);
		sa.setBalance(2000);
		ca.setAccHolder(p2);
		ca.setBalance(3000);
		
		System.out.println("Details of Account");

		System.out.println(sa); //smith's account details
		System.out.println(ca);//kathy's account details
		
		sa.withDraw(1600);
		System.out.println(sa);
		ca.setBalance(4000);
		ca.withDraw(15568);
		System.out.println(ca);
	
	}

}
