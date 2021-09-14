package com.webprj.di.entity;

public class Department {
	private int deptno; // 학과번호
	private String name; // 학과이름

	public Department() {
	}

	public Department(int deptno, String name) {
		this.deptno = deptno;
		this.name = name;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", name=" + name + "]";
	}
}
