package com.webprj.studio.dao;

import java.util.List;

import com.webprj.di.entity.Major;

public interface MajorDao {//학과테이블

	Major getMajor(int majorno);

	List<Major> getMajorList(String query);

}
