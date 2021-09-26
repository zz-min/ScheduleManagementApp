package com.webprj.studio.dao;

import com.webprj.di.entity.Manager;
import com.webprj.di.entity.Professor;
import com.webprj.di.entity.Student;

public interface LoginDao {
	Professor selectProfessor(int profno, String pwd);
	
	Student selectStudent(int studno, String pwd);

	Manager selectManager(int manno, String pwd);
}
