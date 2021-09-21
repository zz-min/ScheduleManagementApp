package com.webprj.di.entity;

public class Studio {
	private int studiono; // 스튜디오 번호 202
	private String loc; // 위치 국제관
	private String dep; // 담당부서

	public Studio() {
	}

	public Studio(int studiono, String loc, String dep) {
		this.studiono = studiono;
		this.loc = loc;
		this.dep = dep;
	}


	public int getStudiono() {
		return studiono;
	}

	public void setStudiono(int studiono) {
		this.studiono = studiono;
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
		return "Studio [stdno=" + studiono + ", loc=" + loc + ", dep=" + dep + "]";
	}
}
