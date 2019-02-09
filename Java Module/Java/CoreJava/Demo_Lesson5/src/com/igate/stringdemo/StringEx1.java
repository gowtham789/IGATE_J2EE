package com.igate.stringdemo;

public class StringEx1 {

	public static void main(String args[]) {
		String s1 = new String("Hai");
		String s2=new String("Hai");
		s1 = s2;
		String s3 = "Hai";

		System.out.println(s1.hashCode() + " " + s2.hashCode() + " "
				+ s3.hashCode());

		System.out.println("s1.equals(s2) :" + s1.equals(s2));
		System.out.println("s1==s2 :" +( s1 == s2));
	}
}
