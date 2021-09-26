package com.webprj.di.entity;

public class Professor {
	private int profno; // 직번 	NUMBER(15) PRIMARY KEY
	private String profname; // 이름 VARCHAR2(15) NOT NULL
	private int majorno; // 학과번호 NUMBER(10) NOT NULL 
	private String pwd; // 패스워드 VARCHAR2(15) NOT NULL
	//deptno : FOREIGN KEY REFERENCES DEPARTMENT(DEPTNO)

	public Professor() {
	}

	public Professor(int profno, String profname, int majorno, String pwd) {
		super();
		this.profno = profno;
		this.profname = profname;
		this.majorno = majorno;
		this.pwd = pwd;
	}

	
	
	public int getProfno() {
		return profno;
	}

	public void setProfno(int profno) {
		this.profno = profno;
	}

	public String getProfname() {
		return profname;
	}

	public void setProfname(String profname) {
		this.profname = profname;
	}

	public int getMajorno() {
		return majorno;
	}

	public void setMajorno(int majorno) {
		this.majorno = majorno;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Professor [profno=" + profno + ", profname=" + profname + ", majorno=" + majorno + ", pwd=" + pwd + "]";
	}
}
