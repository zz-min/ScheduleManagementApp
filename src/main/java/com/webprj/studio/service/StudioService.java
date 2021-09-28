package com.webprj.studio.service;

import java.util.List;

import com.webprj.di.entity.Manager;
import com.webprj.di.entity.Professor;
import com.webprj.di.entity.Reservation;
import com.webprj.di.entity.Student;
import com.webprj.di.entity.Studio;

public interface StudioService {
	
	boolean getLoginFT(int inputID,String inputPWD,String selectLoginType);
	
	Manager getManager(int rsvSeq);
	List<Manager> getManagerList(String query);
	
	Professor getProfessor(int rsvSeq);
	List<Professor> getProfessorList(String query);
	
	Student getStudent(int rsvSeq);
	List<Student> getStudentList(String query);
	
	List<Studio> getStudioList(String query);
	
	List<String> getStudiosLocList();
	
	
	
	Reservation getReservation(int rsvno);
	List<Reservation> getReservationList(String query);
	



}
