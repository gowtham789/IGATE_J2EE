package com.igate.lab7;

import java.util.ArrayList;
import java.util.Collections;

public class ProductArrayList7_2 {

	public static void main(String args[])
	{
		ArrayList<String> empNames=new ArrayList<String>();
		empNames.add("Mobile");
		empNames.add("Pen");
		empNames.add("Laptop");
		empNames.add("Dress");
		empNames.add("Bag");
		
		System.out.println("Using for each loop...");
		for(String e:empNames)
		{
			System.out.println("Names ["+e+"]");
		}
		
		Collections.sort(empNames);
		
		System.out.println("Sorted Array...");
		for(String e1:empNames)
		{
			System.out.println("Names ["+e1+"]");
		}
	}
}
