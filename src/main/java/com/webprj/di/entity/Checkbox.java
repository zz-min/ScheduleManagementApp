package com.webprj.di.entity;

import java.util.Arrays;

public class Checkbox {
	private String[] checkedbox;

	public Checkbox() {}

	public Checkbox(String[] checkedbox) {
		this.checkedbox = checkedbox;
	}

	public String[] getCheckedbox() {
		return checkedbox;
	}

	public void setCheckedbox(String[] checkedbox) {
		this.checkedbox = checkedbox;
	}

	@Override
	public String toString() {
		return "Checkbox [checkedbox=" + Arrays.toString(checkedbox) + "]";
	}
}