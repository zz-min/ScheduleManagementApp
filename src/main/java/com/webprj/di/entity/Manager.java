package com.webprj.di.entity;

public class Manager {
	private int manno; // 관리자직번
	private String manname; // 관리자 이름 NOT NULL
	private String pwd; // 패스워드 NOT NULL
	private String dep; // 부서
	//PRIMARY KEY (MANNO, DEP)
	//DEP : FOREIGN KEY REFERENCES 새로만들테이블(DEP)

	public Manager() {}

	public Manager(int manno, String manname, String pwd, String dep) {
		this.manno = manno;
		this.manname = manname;
		this.pwd = pwd;
		this.dep = dep;
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

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}


	@Override
	public String toString() {
		return "Manager [manno=" + manno + ", manname=" + manname + ", pwd=" + pwd + ", dep=" + dep + "]";
	}


}