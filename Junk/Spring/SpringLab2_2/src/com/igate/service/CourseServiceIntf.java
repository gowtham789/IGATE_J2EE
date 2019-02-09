package com.igate.service;

import java.util.List;

import com.igate.bean.Course;

public interface CourseServiceIntf
{
	Course getCourse(int courseId);
	List<Course> getAllCourses();
	int addCourse(Course c);
	int removeCourse(int courseId);
	int updateCourse(Course c);
}
