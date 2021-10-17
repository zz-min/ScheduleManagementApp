package com.webprj.studio.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webprj.Control.Controller;
import com.webprj.di.entity.Checkbox;
import com.webprj.di.entity.Professor;
import com.webprj.di.entity.Student;
import com.webprj.studio.dao.CheckboxJdbcDao;
import com.webprj.studio.service.StudioService;

public class AdminController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService) {
		/*
		HttpSession session = request.getSession(true);// 세션이 존재하면 세션반환, 없으면 새로운 세션 생성
		
		// 모든 교수 가지고 오기
		List<Professor> professors = null;
		professors = studioService.getProfessorList(null);
		session.setAttribute("professorAllList", professors);

		// 모든 학생 가지고 오기
		List<Student> students = null;
		students = studioService.getStudentList(null);
		session.setAttribute("studentAllList", students);

		// 예약정보가 있는 교수 가지고 오기
		List<Professor> professor = null;
		professor = studioService.getProfessorList(null);
		session.setAttribute("professorAllList", professor);

		// 예약정보가 있는 학생 가지고 오기
		List<Student> student = null;
		student = studioService.getStudentList(null);
		session.setAttribute("studentAllList", student);
		*/
		/////////////철연이꺼 추가
		
		ServletContext context = request.getSession().getServletContext();

		Checkbox chBox = new Checkbox();

		String driver = context.getInitParameter("jdbc_driver");
		String url = context.getInitParameter("db_url");
		String userName = context.getInitParameter("db_userid");
		String password = context.getInitParameter("db_passwd");

		CheckboxJdbcDao boxJdbc = new CheckboxJdbcDao(driver, url, userName, password);
		
		
		System.out.println(request.getParameterValues("checkTest"));
		if( request.getParameterValues("checkTest")!=null) {
			String[] test = request.getParameterValues("checkTest");
			chBox.setCheckedbox(test);
			boxJdbc.insertCheckBox(chBox);
			
			context.setAttribute("NewBox", test);
		}
		
		String[] test2 = boxJdbc.getCheckedBox().getCheckedbox();
		context.setAttribute("SavedBox", test2);
		
		
		return "managerMain.jsp";
		

		//return "admin_professor.jsp";
	}

}
