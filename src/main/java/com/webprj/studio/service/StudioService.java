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
	Professor getProfessor(int rsvSeq);
	Student getStudent(int rsvSeq);
	
	List<Studio> getStudioList(String query);
	
	List<String> getStudiosLocList();
	
	
	
	Reservation getReservation(int rsvSeq);



}
