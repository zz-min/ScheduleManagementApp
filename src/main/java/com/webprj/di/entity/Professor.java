package com.webprj.di.entity;

public class Professor {
	private int profno; // 직번
	private String name; // 이름
	private int deptno; // 학과번호
	private String pwd; // 패스워드

	public Professor() {
	}

	public Professor(int profno, String name, int deptno, String pwd) {
		super();
		this.profno = profno;
		this.name = name;
		this.deptno = deptno;
		this.pwd = pwd;
	}

	public int getProfno() {
		return profno;
	}

	public void setProfno(int profno) {
		this.profno = profno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Professor [profno=" + profno + ", name=" + name + ", deptno=" + deptno + ", pwd=" + pwd + "]";
	}
}
