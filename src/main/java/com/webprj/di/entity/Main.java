package com.webprj.di.entity;

import java.util.Date;

public class Main {
	private int main_seq; // Main 테이블 시퀀스명
	private String btn_name; // 버튼 이름
	private String user_type; // 유저 타입
	private String user_id; // 유저 아이디
	private String user_name; // 유저 이름
	private String pwd; // 유저 비밀번호
	private int content_no; // Content테이블 시퀀스 번호 불러오기
	private Date rsv_date; // 예약 날짜
	private Date startTime; // 시작 시간
	private Date endTime; // 종료 시간
	
	public Main() {}

	public int getMain_seq() {
		return main_seq;
	}

	public void setMain_seq(int main_seq) {
		this.main_seq = main_seq;
	}

	public String getBtn_name() {
		return btn_name;
	}


	public void setBtn_name(String btn_name) {
		this.btn_name = btn_name;
	}


	public String getUser_type() {
		return user_type;
	}


	public void setUser_type(String user_type) {
		this.user_type = user_type;
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
		return "Main [main_seq=" + main_seq + ", btn_name=" + btn_name + ", user_type=" + user_type + ", user_id="
				+ user_id + ", user_name=" + user_name + ", pwd=" + pwd + ", content_no=" + content_no + ", rsv_date="
				+ rsv_date + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
