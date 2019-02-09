package com.igate.lesson13;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {

	public static void main(String[] args) {
		Path javaHome = Paths.get("C:/Program Files/Java/jdk1.7.0_51");
		System.out.println(javaHome.getNameCount()); //3 doesn't count root
		System.out.println(javaHome.getRoot()); // C:\
		System.out.println(javaHome.getName(0));// Program Files
		System.out.println(javaHome.getName(1)); // Java
		System.out.println(javaHome.getFileName()); //jdk1.7.0_51
		System.out.println(javaHome.getParent());
	}
}
