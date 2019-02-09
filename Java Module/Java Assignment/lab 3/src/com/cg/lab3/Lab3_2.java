package com.cg.lab3;

import java.util.Scanner;

public class Lab3_2 {
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	int i;
	int j;
	String result="";
	System.out.println("enter a string");
	String s1=sc.next();
	int len2=s1.length();
	
	for(i=0;i<len2-1;i++){
		char p=s1.charAt(i);
		for(j=1;j<len2;j++)
		{
			char q=s1.charAt(j);
			if(i==j)
				continue;
			else
			{
				if(p<q)
					{
					result="true";
					
					}
				else
					result="false";
				break;
			}
		}
		if(result=="false")
			break;
	}
	System.out.println(result);
}
}
