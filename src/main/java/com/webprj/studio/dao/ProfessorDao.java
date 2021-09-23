package com.webprj.studio.dao;

import java.util.List;

import com.webprj.di.entity.Professor;

public interface ProfessorDao {
	Professor getProfessor(int profno);

	List<Professor> getProfessors(String query);

	int insertReservation(Professor prof);

	int updateReservation(Professor prof);

	int deleteReservation(int profno);

}
