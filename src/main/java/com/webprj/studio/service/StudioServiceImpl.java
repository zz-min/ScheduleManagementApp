package com.webprj.studio.service;

import java.util.List;

import com.webprj.di.entity.Manager;
import com.webprj.di.entity.Professor;
import com.webprj.di.entity.Reservation;
import com.webprj.di.entity.Student;
import com.webprj.di.entity.Studio;
import com.webprj.studio.dao.LoginDao;
import com.webprj.studio.dao.ManagerDao;
import com.webprj.studio.dao.ProfessorDao;
import com.webprj.studio.dao.RsvDao;
import com.webprj.studio.dao.StudentDao;
import com.webprj.studio.dao.StudioDao;


public class StudioServiceImpl implements StudioService {

	private LoginDao loginDao = null;
	private ManagerDao managerDao = null;
	private ProfessorDao professorDao = null;
	private StudentDao studentDao = null;
	private StudioDao studioDao = null;
	private RsvDao rsvDao = null;
	

	
	public StudioServiceImpl(LoginDao loginJdbc,ManagerDao manJdbc,ProfessorDao professorJdbc,StudentDao studentJdbc,
			StudioDao studioJdbc,RsvDao rsvJdbc) {
		this.loginDao = loginJdbc;
		this.managerDao = manJdbc;
		this.professorDao = professorJdbc;
		this.studentDao = studentJdbc;
		this.studioDao = studioJdbc;
		this.rsvDao = rsvJdbc;
	}
	
	@Override
	public boolean getLoginFT(int inputID, String inputPWD, String selectLoginType) {
		// 로그인 유효성 확인	
		if (selectLoginType.equals("manager")) {
			return loginDao.selectManager(inputID, inputPWD) == null ? false : true;
			
		}else if (selectLoginType.equals("professor")) {
			
			return loginDao.selectProfessor(inputID, inputPWD) == null ? false : true;
			
		}else if (selectLoginType.equals("student")) {
			
			return loginDao.selectStudent(inputID, inputPWD) == null ? false : true;
		}else {
			return false;
		}

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
		return rsvDao.getReservationList(query);
	}
	
	
	
	
	


	
	
	
	
	
	/*
	private RsvDao rsvDao;
	private SeatDao seatDao;
	
	public StudioServiceImpl(RsvDao rsvDao, SeatDao seatDao) {
		this.rsvDao = rsvDao;
		this.seatDao = seatDao;
	}

	

	@Override
	public int registerReservation(Reservation rsv) {
		int result = 0;
		
		int rsvSeq = rsvDao.insertReservation(rsv);
		
		result = seatDao.updateSeat(rsv.getSeatNumbers(), rsvSeq);
		
		return result;
	}

	@Override
	public int updateReservation(Reservation rsv) {
		int result = 0;		
		int rsvSeq = rsv.getRsvSeq();
		
		Reservation prevRsv = rsvDao.getReservation(rsvSeq);
		seatDao.updateSeat(prevRsv.getSeatNumbers(), 0);
		
		result = rsvDao.updateReservation(rsv);	
		result = seatDao.updateSeat(rsv.getSeatNumbers(), rsvSeq);
		
		return result;	
	}

	@Override
	public int deleteReservation(Reservation rsv) {
		int result = 0;
		
		result = rsvDao.deleteReservation(rsv.getRsvSeq());
		if (result == 1) {
			result = seatDao.updateSeat(rsv.getSeatNumbers(), 0);
		}
		
		return result;
	}

	@Override
	public List<Integer> getSeatNumbers(boolean booked) {
		return seatDao.getSeatNumbers(booked);
	}
	
	*/
}
