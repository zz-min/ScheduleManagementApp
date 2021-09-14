package com.webprj.studio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webprj.studio.dao.rsvDao;

/**
 * Servlet implementation class StudioController
 */
@WebServlet("/studio")
public class StudioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		String driver = context.getInitParameter("jdbc_driver");
		String url = context.getInitParameter("db_url");
		String userName = context.getInitParameter("db_userid");
		String password = context.getInitParameter("db_passwd");

		System.out.println("StudioController Init()");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		/*
		 * rsvDao dao = (rsvDao) session.getAttribute("dao"); if (dao == null) {
		 * ServletContext context = getServletContext(); dao = new
		 * rsvDao(context.getInitParameter("jdbc_driver"),
		 * context.getInitParameter("db_url"), context.getInitParameter("db_userid"),
		 * context.getInitParameter("db_passwd")); session.setAttribute("dao", dao); }
		 */

		// step #2. data processing
		String pathInfo = request.getRequestURI();
		String action = request.getParameter("action");
		String viewName = null;
		System.out.println(pathInfo);

		if (pathInfo != null && pathInfo.length() > 1) {
			if (pathInfo.equals("/studio")) { // 가장처음 진입페이지
				viewName = "/views/login.jsp";
			} else if (pathInfo.equals("/studio/login")) {
				viewName = "/view/admin.jsp";
			}
		} else if (action != null) {

		}

		// step #3. output processing results
		if (viewName != null) {
			if (viewName.contains("redirect:")) {
				String location = viewName.split(":")[1];// :이걸로 구분한 2번째 원소값을 저장하라
				response.sendRedirect(request.getContextPath() + location);
			} else {
				RequestDispatcher view = request.getRequestDispatcher(viewName);
				view.forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}