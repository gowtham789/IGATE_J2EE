package com.igate.scannerdemo;

import java.util.Scanner;

public class ParseString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner("134,200,313,488,555,69,723,811");
		scanner.useDelimiter(",");
		while (scanner.hasNextInt()) {
			int num = scanner.nextInt();
			if (num % 2 == 0) {
				System.out.println(num+" is even ");
			}
			else
				System.out.println(num+" is odd ");
		}
		scanner.close();
	}
}
