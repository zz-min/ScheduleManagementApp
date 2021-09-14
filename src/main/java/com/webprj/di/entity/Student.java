package com.webprj.di.entity;

public class Student {
	private int studno; // 학번
	private String name; // 이름
	private int grade; // 학년
	private int deptno; // 학과번호
	private String pwd; // 패스워드
	private int professor; // 교수

	public Student() {
	}

	public Student(int studno, String name, int grade, int deptno, String pwd, int professor) {
		this.studno = studno;
		this.name = name;
		this.grade = grade;
		this.deptno = deptno;
		this.pwd = pwd;
		this.professor = professor;
	}

	public int getStudno() {
		return studno;
	}

	public void setStudno(int studno) {
		this.studno = studno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
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

	public int getProfessor() {
		return professor;
	}

	public void setProfessor(int professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return "Student [studno=" + studno + ", name=" + name + ", grade=" + grade + ", deptno=" + deptno + ", pwd="
				+ pwd + ", professor=" + professor + "]";
	}
}
