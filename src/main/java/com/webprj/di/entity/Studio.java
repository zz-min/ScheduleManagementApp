package com.webprj.di.entity;

public class Studio {
	private int studiono; // 스튜디오 
	private String studioloc; // 위치 
	private String dep; // 담당부서 NOT NULL
	//PRIMARY KEY (STUDIONO, LOC)
	//DEP : FOREIGN KEY REFERENCES 새로만들테이블(DEP)

	public Studio() {
	}

	
	public Studio(int studiono, String studioloc, String dep) {
		super();
		this.studiono = studiono;
		this.studioloc = studioloc;
		this.dep = dep;
	}


	public int getStudiono() {
		return studiono;
	}


	public void setStudiono(int studiono) {
		this.studiono = studiono;
	}


	public String getStudioloc() {
		return studioloc;
	}


	public void setStudioloc(String studioloc) {
		this.studioloc = studioloc;
	}


	public String getDep() {
		return dep;
	}


	public void setDep(String dep) {
		this.dep = dep;
	}


	@Override
	public String toString() {
		return "Studio [STUDIONO=" + studiono + ", STUDIOLOC=" + studioloc + ", dep=" + dep + "]";
	}

	
}
