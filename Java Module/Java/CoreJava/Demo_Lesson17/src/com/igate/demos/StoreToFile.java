package com.igate.demos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class StoreToFile {

	public static void main(String[] args) {
		Properties p1=new Properties();
		
		//Put some key value pairs in p1 object
		
		p1.setProperty("Company","Capgemeni");
		p1.setProperty("Date","14-Mar-2016");
		p1.setProperty("Version","1.0");
		p1.setProperty("Location","Chennai");
		
		p1.remove("Version");
		
		//Store it in a properties file
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("file1.properties");
			p1.store(fos, "Propertis for the code");
			System.out.println("File created Successfully!");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
