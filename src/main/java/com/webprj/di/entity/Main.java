package com.webprj.di.entity;

import java.util.Date;

public class Main {
	private int user_seq; // Main 테이블 시퀀스명
	private String btn_name; // 버튼 이름
	private String userId; // 유저 아이디
	private String userName; // 유저 이름
	private String pwd; // 유저 비밀번호
	private int content_no; // Content테이블 시퀀스 번호 불러오기
	private Date rsv_date; // 예약 날짜
	private Date startTime; // 시작 시간
	private Date endTime; // 종료 시간
	
	public Main() {}

	public Main(int user_seq, String btn_name, String userId, String userName, String pwd, int content_no,
			Date rsv_date, Date startTime, Date endTime) {
		this.user_seq = user_seq;
		this.btn_name = btn_name;
		this.userId = userId;
		this.userName = userName;
		this.pwd = pwd;
		this.content_no = content_no;
		this.rsv_date = rsv_date;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public String getBtn_name() {
		return btn_name;
	}

	public void setBtn_name(String btn_name) {
		this.btn_name = btn_name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getContent_no() {
		return content_no;
	}

	public void setContent_no(int content_no) {
		this.content_no = content_no;
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
		return "Main [user_seq=" + user_seq + ", btn_name=" + btn_name + ", userId=" + userId + ", userName=" + userName
				+ ", pwd=" + pwd + ", content_no=" + content_no + ", rsv_date=" + rsv_date + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
}
