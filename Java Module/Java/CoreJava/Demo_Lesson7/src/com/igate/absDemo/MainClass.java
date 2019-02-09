package com.igate.absDemo;

public class MainClass {

	public static void main(String[] args) {
		/* U cant create object for abstract class
		 * BaseClass b1=new BaseClass();
		 */

		BaseClass b2=new D3();
		System.out.println(b2.calculate(6,10));
	}

}
