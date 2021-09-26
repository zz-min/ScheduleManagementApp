package com.webprj.di.entity;

public class Manager {//관리자
	private int manno; // 관리자직번
	private String manname; // 관리자 이름 NOT NULL
	private String pwd; // 패스워드 NOT NULL
	private int deptno; // 부서
	//PRIMARY KEY (MANNO, DEP)
	//DEP : FOREIGN KEY REFERENCES 새로만들테이블(DEP)

	public Manager() {}

	
	public Manager(int manno, String manname, String pwd, int deptno) {
		super();
		this.manno = manno;
		this.manname = manname;
		this.pwd = pwd;
		this.deptno = deptno;
	}


	public int getManno() {
		return manno;
	}


	public void setManno(int manno) {
		this.manno = manno;
	}


	public String getManname() {
		return manname;
	}


	public void setManname(String manname) {
		this.manname = manname;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int depno) {
		this.deptno = depno;
	}


	@Override
	public String toString() {
		return "Manager [manno=" + manno + ", manname=" + manname + ", pwd=" + pwd + ", deptno=" + deptno + "]";
	}

}