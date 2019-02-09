package com.cg.lab3;

import java.util.Scanner;

public class Lab3_1 {

	 public static void main(String args[])
	 {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("enter a string");
		 String s1=sc.next();
		 String s=s1;
		 int i;
		 int j;
		 int count;
		 System.out.println("enter the choice");
		 System.out.println("1)add a string to itself");
		 System.out.println("2)replace odd position with #");
		 System.out.println("3)remove duplicate characters in string");
		 System.out.println("4)change odd characters to uppercase");
		 int choice=sc.nextInt();
		 switch(choice)
		 {
		 case 1:
			     String s2=s1;
			     System.out.println("string added to itself");
			     System.out.println("new string is"+(s2+s1));
			     break;
			     
		 case 2:int len=s1.length();
		        String fin;
		        char x;
		        fin=" ";
		             for(i=0;i<len;i++)
		               {
		            	 if(i%2==0)
		            	 {
		        	       fin=fin+'#';
		              }
		       
		             else
		                {
		        	      x=s1.charAt(i);
		        	        fin=fin+x;
		              }
		        
		 }
		 System.out.println("string replaced with odd position:" +fin);
		 break;
		 
		 case 3:  String s3=s;
		          String dup="";
		          char p;
		          char q;
		          int len1=s3.length();
		          for(i=0;i<len1;i++)
		          {
		        	  count=0;
		        	  p=s3.charAt(i);
		        	  for(j=0;j<len1;j++)
		        	  {
		        		   if(i==j)
		        			   continue;
		        		   else
		        		   {
		        			   q=s3.charAt(j);
		        			   if(p==q)
		        				   
		        			   {
		        				   count++;
		        			   }
		        		   }
		        	  }
		        	  if(count==0)
		        	  {
		        		  dup=dup+p;
		        	  }
		          }
		        System.out.println("string after remove duplicate:"+dup);
		        break;
		        
		        
		 case 4:
			     int len2=s1.length();
			     StringBuilder temp=new StringBuilder();
			     
			     for(i=0;i<len2;i++)
			     {
			    	 if((i+1)%2==0)
			    	 {
			    		 char c1=s1.charAt(i);
			    		 temp.append(c1);
			    	 }
			    	 else
			    	 {
			    		 char c1=s1.charAt(i);
			    		 String stemp=String.valueOf(c1);
			    		 temp.append(stemp.toUpperCase());
			    	 }
			     }
			     System.out.println(temp);
	 }
}
}
		        			
