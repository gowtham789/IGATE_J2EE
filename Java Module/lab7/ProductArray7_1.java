package com.igate.lab7;

import java.util.Arrays;

public class ProductArray7_1 {

	public static void main(String[] args) {
		
		String p[]=new String[5];
		p[0]="Mobile";
		p[1]="Laptop";
		p[2]="Pen";
		p[3]="Dress";
		p[4]="Bag";
		
		for(int i=0;i<p.length;i++)
		{
			System.out.println(p[i]);
		}
		
		//For each loop to iterate an array
		System.out.println("Using for each loop...");
		for(String temp:p)
		{
			System.out.println(temp);
		}
		
		Arrays.sort(p);
		
		System.out.println("Sorted Array...");
		for(String temp:p)
		{
			System.out.println(temp);
		}
	}
}
