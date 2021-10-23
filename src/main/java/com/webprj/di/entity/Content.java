package com.webprj.di.entity;

public class Content {
	private int content_seq; // Content 테이블 시퀀스
	private String mainCategory; // 메인 카테고리 ex) 국제관, 웹캠
	private int subCategory; // 서브 카테고리 ex) 202, 1 -> 메인과 연결해서 사용
	
	public Content() {}

	public Content(int content_seq, String mainCategory, int subCategory) {
		this.content_seq = content_seq;
		this.mainCategory = mainCategory;
		this.subCategory = subCategory;
	}

	public int getContent_seq() {
		return content_seq;
	}

	public void setContent_seq(int content_seq) {
		this.content_seq = content_seq;
	}

	public String getMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}

	public int getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(int subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "Content [content_seq=" + content_seq + ", mainCategory=" + mainCategory + ", subCategory=" + subCategory
				+ "]";
	}
}
