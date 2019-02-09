package com.igate.list.demos;

import java.util.*;

public class ListDemo {

	public static void main(String[] args) {
		
		//A List without generics
		//Any object can be stored which can cause a problem
		LinkedList al=new LinkedList();
		System.out.println("Created but no elements : "+al.size());
		al.add(67);
		al.add(78);
		al.add(9);
		System.out.println("Added 3 elements :"+al.size());
		al.add(55);
		al.add("Hai");
		al.add("Sugan");
		
		System.out.println("Added elements :"+al.size());
		System.out.println(al);
		
		

	}

}
