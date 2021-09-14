package com.webprj.di.entity;

import java.util.Date;

public class Reservation {
	private int rsvno; // 예약번호
	private int studno; // 학번
	private int profno; // 직번
	private int stdono; // 스튜디오번호
	private int manno; // 관리자직번
	private Date rsvDate; // 예약날짜
	private Date StartTime; // 시작시간
	private Date EndTime; // 종료시간

	public Reservation() {
	}

	public Reservation(int rsvno, int studno, int profno, int stdono, int manno, Date rsvDate, Date startTime,
			Date endTime) {
		this.rsvno = rsvno;
		this.studno = studno;
		this.profno = profno;
		this.stdono = stdono;
		this.manno = manno;
		this.rsvDate = rsvDate;
		StartTime = startTime;
		EndTime = endTime;
	}

	public int getRsvno() {
		return rsvno;
	}

	public void setRsvno(int rsvno) {
		this.rsvno = rsvno;
	}

	public int getStudno() {
		return studno;
	}

	public void setStudno(int studno) {
		this.studno = studno;
	}

	public int getProfno() {
		return profno;
	}

	public void setProfno(int profno) {
		this.profno = profno;
	}

	public int getStdono() {
		return stdono;
	}

	public void setStdono(int stdono) {
		this.stdono = stdono;
	}

	public int getManno() {
		return manno;
	}

	public void setManno(int manno) {
		this.manno = manno;
	}

	public Date getRsvDate() {
		return rsvDate;
	}

	public void setRsvDate(Date rsvDate) {
		this.rsvDate = rsvDate;
	}

	public Date getStartTime() {
		return StartTime;
	}

	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}

	public Date getEndTime() {
		return EndTime;
	}

	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}

	@Override
	public String toString() {
		return "Reservation [rsvno=" + rsvno + ", studno=" + studno + ", profno=" + profno + ", stdono=" + stdono
				+ ", manno=" + manno + ", rsvDate=" + rsvDate + ", StartTime=" + StartTime + ", EndTime=" + EndTime
				+ "]";
	}
}
