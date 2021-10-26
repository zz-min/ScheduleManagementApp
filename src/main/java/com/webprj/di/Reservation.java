package com.webprj.di;

import java.util.Date;

public class Reservation {
	private int rsvno; // 예약번호 PRIMARY KEY
	private String user_id; // 유저 아이디
	private String user_name; // 유저 이름
	private int content_no; // Content테이블 시퀀스 번호 불러오기
	private String mainCategory; // 메인 카테고리 ex) 국제관, 웹캠
	private int subCategory; // 서브 카테고리 ex) 202, 1 -> 메인과 연결해서 사용
	private Date rsv_date; // 예약 날짜
	private Date startTime; // 시작 시간
	private Date endTime; // 종료 시간
	
	public Reservation() {
		
	}
	public Reservation(int rsvno, String user_id, String user_name, int content_no, String mainCategory,
			int subCategory, Date rsv_date, Date startTime, Date endTime) {
		super();
		this.rsvno = rsvno;
		this.user_id = user_id;
		this.user_name = user_name;
		this.content_no = content_no;
		this.mainCategory = mainCategory;
		this.subCategory = subCategory;
		this.rsv_date = rsv_date;
		this.startTime = startTime;
		this.endTime = endTime;
	}


	public int getRsvno() {
		return rsvno;
	}


	public void setRsvno(int rsvno) {
		this.rsvno = rsvno;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public int getContent_no() {
		return content_no;
	}


	public void setContent_no(int content_no) {
		this.content_no = content_no;
	}


	public String getMainCategory() {
		return mainCategory;
	}


	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}


	public int getSubCategory() {
		return subCategory;
	}


	public void setSubCategory(int subCategory) {
		this.subCategory = subCategory;
	}


	public Date getRsv_date() {
		return rsv_date;
	}


	public void setRsv_date(Date rsv_date) {
		this.rsv_date = rsv_date;
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
		return "Reservation [rsvno=" + rsvno + ", user_id=" + user_id + ", user_name=" + user_name + ", content_no="
				+ content_no + ", mainCategory=" + mainCategory + ", subCategory=" + subCategory + ", rsv_date="
				+ rsv_date + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
