package com.igate.demos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ReadFromFile {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("example.properties");

		Properties p2 = new Properties();

		p2.load(fis);

		System.out.println("All the properties");
		System.out.println(p2);

		System.out.println("p2.get(Topic) =" + p2.get("Topic"));

		System.out.println("Using for each iterator");

		Set<Object> keys = p2.keySet();
		for (Object k : keys) {
			System.out.println(k + " " + p2.getProperty((String) k));
		}

	}

}
