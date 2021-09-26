package com.webprj.studio.dao;

import java.util.List;

import com.webprj.di.entity.Professor;

public interface ProfessorDao {
	
	Professor getProfessor(int profno);

	List<Professor> getProfessorList(String query);

}
