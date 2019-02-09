package com.capgemini.Lab6.q2;
import com.capgemini.Lab6.q2.*;
import java.util.*;
public class AccountHolder {

	public static void main(String[] args) {
		String name1 = "Smith";
		String name2 = "Honey";
		double bal1 = 0;
		double bal2 = 3000;
		Person acntHolder1 = new Person();
		Person acntHolder2 = new Person();
		acntHolder1.setName(name1);
		acntHolder2.setName(name2);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st person age :");
		int age = sc.nextInt();
		try
		{
			if(age>15){acntHolder1.setAge(age);}
			else{throw new Exception();}
		}
		catch(Exception e)
		{
			System.out.println("Please Enter age > 15");
			System.exit(0);
		}
		System.out.println("Enter 2nd person age : ");
		int age2 = sc.nextInt();
		try
		{
			if(age2>15){acntHolder1.setAge(age2);}
			else{throw new Exception();}
		}
		catch(Exception e)
		{
			System.out.println("Please Enter age > 15");
			System.exit(0);
		}
		acntHolder2.setAge(age2);
		Account acnt1 = new SavingsAccount();
		acnt1.setAccHolder(acntHolder1);
	    acnt1.setBalance(bal1);
		Account acnt2 = new CurrentAccount();
		acnt2.setAccHolder(acntHolder2);
		acnt2.setBalance(bal2);
		System.out.println("Details of Account");
		System.out.println(acnt1);
		System.out.println(acnt2);
		acnt1.deposit(2000);
		acnt2.withDraw(2000);
		System.out.println("After manipulation");
		System.out.println(acnt1);
		System.out.println(acnt2);
		acnt1.withDraw(300);
		System.out.println(acnt1);
		acnt2.withDraw(150000);
		System.out.println(acnt2);
	}

}
