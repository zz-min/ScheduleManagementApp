package com.webprj.studio.dao;

import java.util.List;

import com.webprj.di.entity.Student;

public interface StudentDao {
	List<Student> getStudentList(String query);

	int insertStudent(Student student);

	int updateStudent(Student student);

	int deleteStudent(Student student);
}
