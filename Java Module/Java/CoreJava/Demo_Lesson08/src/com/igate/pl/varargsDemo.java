package com.igate.pl;

public class varargsDemo {

	//The last argument can take 0 to more values
	int add(int x,int y,int...z)
	{
		int sum=x+y;
		for(int temp=0;temp<z.length;temp++)
		{
			sum=sum+z[temp];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		varargsDemo v1=new varargsDemo ();
		System.out.println(v1.add(5, 6, 7,2,10));
		System.out.println(v1.add(3,4,5,5,5,10,2));
		System.out.println(v1.add(10,20));
	}

}
