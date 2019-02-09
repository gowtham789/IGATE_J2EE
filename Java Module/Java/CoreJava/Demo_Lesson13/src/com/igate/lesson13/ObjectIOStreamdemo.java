package com.igate.lesson13;

import java.io.*;

public class ObjectIOStreamdemo {
	public static void main(String args[]) {
		try(FileOutputStream fos = new FileOutputStream("info.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			Student s1 = new Student(100, "Varsha");
			System.out.println("s1 object : " + s1);

			
			oos.writeObject(s1);
			oos.flush();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try(FileInputStream fis = new FileInputStream("info.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			Student s2;
			
			s2 = (Student) ois.readObject();
			System.out.println("s2 object : " + s2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
