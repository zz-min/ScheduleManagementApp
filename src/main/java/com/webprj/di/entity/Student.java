package com.webprj.di.entity;

public class Student {
	private int studentno; // 학번 PRIMARY KEY
	private String studentname; // 이름 NOT NULL
	private int grade; // 학년 NOT NULL DEFAULT 1
	private int majorno; // 학과번호 NOT NULL
	private String pwd; // 패스워드 NOT NULL
	private int profno; // 교수
	//majorno :  FOREIGN KEY REFERENCES MAJOR(majorno)

	public Student() {
	}

	public Student(int studentno, String studentname, int grade, int majorno, String pwd, int profno) {
		super();
		this.studentno = studentno;
		this.studentname = studentname;
		this.grade = grade;
		this.majorno = majorno;
		this.pwd = pwd;
		this.profno = profno;
	}

	public int getStudentno() {
		return studentno;
	}

	public void setStudentno(int studentno) {
		this.studentno = studentno;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
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

	public int getProfno() {
		return profno;
	}

	public void setProfno(int profno) {
		this.profno = profno;
	}

	@Override
	public String toString() {
		return "Student [studentno=" + studentno + ", studentname=" + studentname + ", grade=" + grade + ", majorno="
				+ majorno + ", pwd=" + pwd + ", profno=" + profno + "]";
	}



}
