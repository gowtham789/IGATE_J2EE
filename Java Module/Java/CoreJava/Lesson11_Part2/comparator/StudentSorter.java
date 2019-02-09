package com.igate.comparator;

import java.util.Comparator;

public class StudentSorter implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getMark1()>o2.getMark1())
			return 1;
		else if(o1.getMark1()<o2.getMark1())
			return -1;
		else
		return 0;
	}
}
