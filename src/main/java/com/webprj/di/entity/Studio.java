package com.webprj.di.entity;

public class Studio {
	private int studiono; // 스튜디오 
	private String studioloc; // 위치 
	private int deptno; // 담당부서 NOT NULL
	//PRIMARY KEY (STUDIONO, LOC)
	//deptno :  FOREIGN KEY REFERENCES DEPARTMENT(depno)

	public Studio() {
	}

	public Studio(int studiono, String studioloc, int deptno) {
		super();
		this.studiono = studiono;
		this.studioloc = studioloc;
		this.deptno = deptno;
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


	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	@Override
	public String toString() {
		return "Studio [studiono=" + studiono + ", studioloc=" + studioloc + ", deptno=" + deptno + "]";
	}

}
