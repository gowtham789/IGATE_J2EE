package com.igate.ln4.demos;

public class BoxMain {

	public static void main(String[] args) {
		Box b1;
		b1=new Box();//Default constructor is called
		System.out.println("B1 = "+b1.calculate());
		
		Box b2;
		b2=new Box(7,5,10);//Param const
		System.out.println("B2 = "+b2.calculate());

	}

}
