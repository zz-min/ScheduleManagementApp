package com.webprj.studio.service;

import java.util.List;

import com.webprj.di.entity.Manager;
import com.webprj.di.entity.Professor;
import com.webprj.di.entity.Reservation;
import com.webprj.di.entity.Student;
import com.webprj.di.entity.Studio;
import com.webprj.studio.dao.ManagerDao;
import com.webprj.studio.dao.ProfessorDao;
import com.webprj.studio.dao.RsvDao;
import com.webprj.studio.dao.StudentDao;
import com.webprj.studio.dao.StudioDao;


public class StudioServiceImpl implements StudioService {

	private ManagerDao managerDao = null;
	private ProfessorDao professorDao = null;
	private StudentDao studentDao = null;
	private StudioDao studioDao = null;
	private RsvDao rsvDao = null;
	
	public StudioServiceImpl(ManagerDao manJdbc,ProfessorDao professorJdbc,StudentDao studentJdbc,
			StudioDao studioJdbc,RsvDao rsvJdbc) {
		this.managerDao = manJdbc;
		this.professorDao = professorJdbc;
		this.studentDao = studentJdbc;
		this.studioDao = studioJdbc;
		this.rsvDao = rsvJdbc;
	}
	
	@Override
	public boolean getLoginFT(int inputID,String inputPWD,String selectLoginType) {
		return false;
		// 로그인 유효성 확인	
		/*
		 * if (selectLoginType.equals("manager")) { return
		 * loginDao.selectManager(inputID, inputPWD) == null ? false : true;
		 * 
		 * }else if (selectLoginType.equals("professor")) {
		 * 
		 * return loginDao.selectProfessor(inputID, inputPWD) == null ? false : true;
		 * 
		 * }else if (selectLoginType.equals("student")) {
		 * 
		 * return loginDao.selectStudent(inputID, inputPWD) == null ? false : true;
		 * }else { return false; }
		 */

	}
	
	
	@Override
	public Manager getManager(int manno) {
		return managerDao.getManager(manno);
	}
	
	@Override
	public List<Manager> getManagerList(String query) {
		return managerDao.getManagerList(query);
	}
	
	@Override
	public Professor getProfessor(int profno) {
		return professorDao.getProfessor(profno);
	}
	
	@Override
	public List<Professor> getProfessorList(String query) {
		return professorDao.getProfessorList(query);
	}
	
	@Override
	public Student getStudent(int studentno) {
		return studentDao.getStudent(studentno);
	}
	
	@Override
	public List<Student> getStudentList(String query) {
		return studentDao.getStudentList(query);
	}

	
	@Override
	public List<Studio> getStudioList(String query) {
		return studioDao.getStudioList(query);
	}
	
	@Override
	public List<String> getStudiosLocList() {
		return studioDao.getStudiosLocList();
	}

	
	
	@Override
	public Reservation getReservation(int rsvno) {
		
		return null;
	}
	@Override
	public List<Reservation> getReservationList(String query) {
		return rsvDao.getReservationList(query);//rrrrmm
	}

	@Override
	public List<Reservation> getRsvList(String query) {
		return rsvDao.getRsvList(query);//rrrrmmdd
	}
}