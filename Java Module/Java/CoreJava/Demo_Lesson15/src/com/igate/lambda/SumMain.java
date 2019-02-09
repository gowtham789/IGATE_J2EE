package com.igate.lambda;

public class SumMain {

	public static void main(String[] args) {
		SumInterface si=(int a,int b,int c)->{
			int sum;
			sum=a+b+c;
			return sum;
		};
		
		int result=si.sumOfNum(67,22,14);
		
		System.out.println(result);

	}

}
