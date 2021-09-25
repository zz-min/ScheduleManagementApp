package com.webprj.di.entity;

public class Department {
	private int deptno; // 학과번호 NUMBER(10) PRIMARY KEY
	private String deptname; // 학과이름 VARCHAR2(30) NOT NULL  UNUQUE

	public Department() {
	}

	public Department(int deptno, String deptname) {
		this.deptno = deptno;
		this.deptname = deptname;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", deptname=" + deptname + "]";
	}
}
