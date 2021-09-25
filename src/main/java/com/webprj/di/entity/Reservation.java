package com.webprj.di.entity;

import java.util.Date;

public class Reservation {
	private int rsvno; // 예약번호 PRIMARY KEY
	private int studentno; // 학번
	private int profno; // 직번
	private int studiono; // 스튜디오번호
	private String studioloc; //스튜디오위치
	private int manno; // 관리자직번  NOT NULL
	private String dep; // 부서 
	private Date rsvDate; // 예약날짜 NOT NULL
	private Date startTime; // 시작시간 NOT NULL
	private Date endTime; // 종료시간 NOT NULL
	
	//STUDENTNO : FOREIGN KEY REFERENCES STUDENT(STUDENTNO)
	//PROFNO : FOREIGN KEY REFERENCES PROFESSOR(PROFNO)
	
	//STUDIONO ,STUDIOLOC : FOREIGN KEY REFERENCES STUDIO (STUDIONO , STUDIOLOC );
	//예정)manno , dep: FOREIGN KEY REFERENCES  MANAGER
	
	public Reservation() {
		
	}

	public Reservation(int rsvno, int studentno, int profno, int studiono, String studioloc, int manno, String dep,
			Date rsvDate, Date startTime, Date endTime) {
		super();
		this.rsvno = rsvno;
		this.studentno = studentno;
		this.profno = profno;
		this.studiono = studiono;
		this.studioloc = studioloc;
		this.manno = manno;
		this.dep = dep;
		this.rsvDate = rsvDate;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getRsvno() {
		return rsvno;
	}

	public void setRsvno(int rsvno) {
		this.rsvno = rsvno;
	}

	public int getStudentno() {
		return studentno;
	}

	public void setStudentno(int studentno) {
		this.studentno = studentno;
	}

	public int getProfno() {
		return profno;
	}

	public void setProfno(int profno) {
		this.profno = profno;
	}

	public int getStudiono() {
		return studiono;
	}

	public void setStudiono(int studiono) {
		this.studiono = studiono;
	}

	public String getStudioloc() {
		return studioloc;
	}

	public void setStudioloc(String studioloc) {
		this.studioloc = studioloc;
	}

	public int getManno() {
		return manno;
	}

	public void setManno(int manno) {
		this.manno = manno;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public Date getRsvDate() {
		return rsvDate;
	}

	public void setRsvDate(Date rsvDate) {
		this.rsvDate = rsvDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Reservation [rsvno=" + rsvno + ", studentno=" + studentno + ", profno=" + profno + ", studiono="
				+ studiono + ", studioloc=" + studioloc + ", manno=" + manno + ", dep=" + dep + ", rsvDate=" + rsvDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	
	
}
