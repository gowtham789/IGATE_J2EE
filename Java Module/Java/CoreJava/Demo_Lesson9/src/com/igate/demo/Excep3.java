package com.igate.demo;

import java.io.*;

public class Excep3 {

	public static void main(String[] args) {
		// The below line will cause CompileTime Exception
		//try/catch or throws is  compulsory
		
		//try/catch
		try
		{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String msg=br.readLine();
		}
		catch(IOException ie)
		{
			System.out.println("Exception");
		}
	}

}
