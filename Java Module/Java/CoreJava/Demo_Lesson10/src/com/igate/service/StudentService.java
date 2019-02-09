package com.igate.service;

import com.igate.bean.Student;

public class StudentService implements IStudentService{

	@Override
	public float calcAggregate(Student[] stu) {
		float overallAgg=0.0f;
		
		for(Student s:stu)
		{
			overallAgg=overallAgg+s.getAggregate();
		}
		
		float res=overallAgg/stu.length;
		return res;
	}

}
