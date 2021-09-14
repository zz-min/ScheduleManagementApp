package com.webprj.di.entity;

public class Studio {
	private int stdno; // 스튜디오 번호 202
	private String loc; // 위치 국제관
	private String dep; // 담당부서

	public Studio() {
	}

	public Studio(int stdno, String loc, String dep) {
		this.stdno = stdno;
		this.loc = loc;
		this.dep = dep;
	}

	public int getStdno() {
		return stdno;
	}

	public void setStdno(int stdno) {
		this.stdno = stdno;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	@Override
	public String toString() {
		return "Studio [stdno=" + stdno + ", loc=" + loc + ", dep=" + dep + "]";
	}
}
