package com.igate.lesson13;

/*	Copy a File.
 Command syntax: java CopyFile <from-file> <to-file>
 */

import java.io.*;

class CopyFile {

	FileInputStream fromFile;
	FileOutputStream toFile;

	public void init() {
		//Assign the files
		try {
			fromFile = new FileInputStream("Input.txt");
			toFile = new FileOutputStream("Output.txt");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Exception: " + fnfe);
			return;
		}  catch (ArrayIndexOutOfBoundsException aioe) {
			System.out.println("Exception: " + aioe);
			return;
		}

	}

	public void copyContents() {

		// copy bytes
		try {
			int i = fromFile.read();
			while (i != -1) { //check the end of file
				toFile.write(i);
				i = fromFile.read();
			}
		} catch (IOException ioe) {
			System.out.println("Exception: " + ioe);
			return;
		}
	}

	public void closeFiles() {

		//close the files
		try {
			fromFile.close();
			toFile.close();

		} catch (IOException ioe) {
			System.out.println("Exception: " + ioe);
			return;
		}
	}

	public static void main(String[] args) {

		CopyFile c1 = new CopyFile();
		c1.init();
		c1.copyContents();
		c1.closeFiles();
	}
}
