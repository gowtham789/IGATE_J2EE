package com.igate.pl;

import java.util.Arrays;

public class ArrayMain {

	public static void main(String[] args) {
		int marks[]=new int[5];
		marks[0]=78;
		marks[1]=89;
		marks[2]=90;
		marks[3]=34;
		marks[4]=66;
		
		for(int i=0;i<marks.length;i++)
		{
			System.out.println(marks[i]);
		}
		
		//For each loop to iterate an array
		System.out.println("Using for each loop...");
		for(int temp:marks)
		{
			System.out.println(temp);
		}
		
		Arrays.sort(marks);
		
		System.out.println("Sorted Array...");
		for(int temp:marks)
		{
			System.out.println(temp);
		}
		
		int newMarks[]=Arrays.copyOfRange(marks, 2, 4);
		System.out.println("New Marks Array :");

		for(int temp:newMarks)
		{
			System.out.println(temp);
		}

	}

}
