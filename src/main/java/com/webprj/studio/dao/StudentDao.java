package com.webprj.studio.dao;

import java.util.List;

import com.webprj.di.entity.Student;

public interface StudentDao {
	
	Student getStudent(int studentno);
	
	List<Student> getStudentList(String query);


}
