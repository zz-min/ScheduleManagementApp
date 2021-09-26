package com.webprj.di.entity;

public class Department {//학교부서

	private int deptno; // 부서 번호
	private String deptname; // 부서 이름
	private String phone; // 부서 전화
	
	public Department() {}

	public Department(int deptno, String deptname, String phone) {
		this.deptno = deptno;
		this.deptname = deptname;
		this.phone = phone;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", deptname=" + deptname + ", phone=" + phone + "]";
	}
}
