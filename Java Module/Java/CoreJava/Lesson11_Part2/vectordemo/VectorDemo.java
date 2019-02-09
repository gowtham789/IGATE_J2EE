package com.igate.vectordemo;

import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
		//Capacity=3, and it doubles when more elements are added
		Vector<Integer> v1=new Vector<Integer>(3);
		
		System.out.println("Capacity : "+v1.capacity()+" Size : "+v1.size());
		v1.add(1);
		v1.add(2);
		v1.add(3);
		v1.add(4);
		
		System.out.println("Capacity : "+v1.capacity()+" Size : "+v1.size());
		System.out.println(v1);
		
		v1.add(5);
		v1.add(6);
		v1.add(7);
		v1.add(8);
		
		
		System.out.println("Capacity : "+v1.capacity()+" Size : "+v1.size());
		System.out.println(v1);
		
		
		//Capacity=3,scale=5 and it doubles when more elements are added
				Vector<Integer> v2=new Vector<Integer>(3,5);
				
				System.out.println("Capacity : "+v2.capacity()+" Size : "+v2.size());
				v2.add(1);
				v2.add(2);
				v2.add(3);
				v2.add(4);
				
				System.out.println("Capacity : "+v2.capacity()+" Size : "+v2.size());
				System.out.println(v2);
				
				v2.add(5);
				v2.add(6);
				v2.add(7);
				v2.add(8);
				v2.add(9);
				v2.add(10);
				v2.add(11);
				
				
				System.out.println("Capacity : "+v2.capacity()+" Size : "+v2.size());
				System.out.println(v2);
		

	}

}
