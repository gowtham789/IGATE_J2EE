package com.igate.pl;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.igate.bean.Student;
import com.igate.service.IStudentService;
import com.igate.service.StudentService;

public class StudentMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Create Student Objects
		Student s1 = new Student();
		System.out.println("------Student 1------");

		String idPattern = "[1-9][0-9]{2}";

		while (true) {
			System.out.println("Enter the StudentId  - 3 digits only");
			int idTemp = sc.nextInt();
			if (Pattern.matches(idPattern, String.valueOf(idTemp))) {
				s1.setStuId(idTemp);
				break;
			} else {
				System.err.println("Please enter a 3 digit number");
			}
		}

		String namePattern = "[A-Z][a-z]+";
		while (true) {
			System.out.println("Enter the Student Name");
			String nameTemp = sc.next();

			if (Pattern.matches(namePattern, nameTemp)) {
				s1.setName(nameTemp);
				break;
			} else {
				System.err.println("Please valid name starting with Caps:");
			}
		}

		System.out.println("Enter the Course");
		s1.setCourse(sc.next());

		System.out.println("Enter the Aggregate");
		s1.setAggregate(sc.nextFloat());

		Student s2 = new Student();
		System.out.println("------Student 2------");
		System.out.println("Enter the StudentId");
		s2.setStuId(sc.nextInt());

		System.out.println("Enter the Student Name");
		s2.setName(sc.next());

		System.out.println("Enter the Course");
		s2.setCourse(sc.next());

		System.out.println("Enter the Aggregate");
		s2.setAggregate(sc.nextFloat());

		Student s3 = new Student();
		System.out.println("------Student 3------");
		System.out.println("Enter the StudentId");
		s3.setStuId(sc.nextInt());

		System.out.println("Enter the Student Name");
		s3.setName(sc.next());

		System.out.println("Enter the Course");
		s3.setCourse(sc.next());

		System.out.println("Enter the Aggregate");
		s3.setAggregate(sc.nextFloat());

		// Create an Array of students

		Student stuArray[] = new Student[3];
		stuArray[0] = s1;
		stuArray[1] = s2;
		stuArray[2] = s3;

		// Displaying student details

		System.out.println("----Displaying student details----");

		for (Student temp : stuArray) {
			System.out.println("--------------------------------");
			System.out.println(temp);
			System.out.println("---------------------------------");
		}

		// Call the service to calculate the average aggregate

		IStudentService studServ = new StudentService();
		float avg = studServ.calcAggregate(stuArray);

		System.out.println("____________________");
		System.out.println("The average aggregate is : "+avg);
	}

}
