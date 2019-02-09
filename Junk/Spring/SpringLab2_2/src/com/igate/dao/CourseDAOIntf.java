package com.igate.dao;

import java.util.List;

import com.igate.bean.Course;

public interface CourseDAOIntf
{
	Course getCourse(int courseId);
	List<Course> getAllCourses();
	int addCourse(Course c);
	int removeCourse(int courseId);
	int updateCourse(Course c);
	
}
