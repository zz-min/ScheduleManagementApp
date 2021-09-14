package com.webprj.di.entity;

public class Manager {
	private int manno; // 관리자직번
	private String pwd; // 패스워드
	private String dep; // 부서

	public Manager() {
	}

	public Manager(int manno, String pwd, String dep) {
		this.manno = manno;
		this.pwd = pwd;
		this.dep = dep;
	}

	public int getManno() {
		return manno;
	}

	public void setManno(int manno) {
		this.manno = manno;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	@Override
	public String toString() {
		return "Manager [manno=" + manno + ", pwd=" + pwd + ", dep=" + dep + "]";
	}
}
