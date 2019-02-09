package com.igate.interfacedemo;

public class C1 implements I1,I2{

	@Override
	public int calc() {
		// TODO Auto-generated method stub
		return (int)ROI*100;
	}

	@Override
	public void display() {
		System.out.println(name+" "+x);
		
	}
	
	public static void main(String args[])
	{
		C1 c=new C1();
		c.display();
		System.out.println(c.calc());
		
		I1 i=new C1();
		i.display();
		
		
		
		
	}

}
