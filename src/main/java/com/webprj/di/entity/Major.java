package com.webprj.di.entity;

public class Major {//학과테이블
	private int majorno;// 학과번호 NUMBER(10) PRIMARY KEY
	private String mojorname;// 학과이름 VARCHAR2(30) NOT NULL  UNUQUE
	
	public Major() {}

	public Major(int majorno, String mojorname) {
		this.majorno = majorno;
		this.mojorname = mojorname;
	}

	public int getMajorno() {
		return majorno;
	}

	public void setMajorno(int majorno) {
		this.majorno = majorno;
	}

	public String getMojorname() {
		return mojorname;
	}

	public void setMojorname(String mojorname) {
		this.mojorname = mojorname;
	}

	@Override
	public String toString() {
		return "Major [majorno=" + majorno + ", mojorname=" + mojorname + "]";
	}
	
}