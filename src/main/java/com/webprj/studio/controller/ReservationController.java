package com.webprj.studio.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webprj.Control.Controller;
import com.webprj.di.entity.Manager;
import com.webprj.di.entity.Professor;
import com.webprj.di.entity.Reservation;
import com.webprj.di.entity.Student;
import com.webprj.studio.service.StudioService;

public class ReservationController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService) {
		String method = request.getMethod().toUpperCase();//요청메소드를 모두 대문자로반환 post -> POST
		System.out.println(method);
		
			int id = (int) request.getAttribute("id");
			String loginType = (String) request.getAttribute("loginType");
			String str = null;

			if (loginType.equals("manager")) {
				str = "manno = " + id;

			} else if (loginType.equals("professor")) {
				str = "profno = " + id;

			} else if (loginType.equals("student")) {
				str = "studentno = " + id;
			}

			List<Reservation> rsvList = studioService.getReservationList(str);

			request.setAttribute("rsvList", rsvList);

			return "userPage.jsp";
	}

}
