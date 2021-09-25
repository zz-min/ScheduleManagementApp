package com.webprj.studio.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webprj.di.entity.Manager;
import com.webprj.di.entity.Professor;
import com.webprj.di.entity.Student;
import com.webprj.di.entity.Studio;
import com.webprj.studio.dao.LoginJdbcDao;
import com.webprj.studio.dao.ManagerJdbcDao;
import com.webprj.studio.dao.ProfessorJdbcDao;
import com.webprj.studio.dao.RsvJdbcDao;
import com.webprj.studio.dao.StudioJdbcDao;

/**
 * Servlet implementation class StudioController
 */
@WebServlet("/studio/*")
public class StudioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession session = null;
	//session = request.getSession(false);//세션이 존재하면 세션반환, 없으면 NULL반환
	//session = request.getSession(true);//세션이 존재하면 세션반환, 없으면 새로운세션생성

	private LoginJdbcDao loginJdbc = null;
	
	private StudioJdbcDao studioJdbc=null;
	private ProfessorJdbcDao professorJdbc=null;
	private ManagerJdbcDao manJdbc = null;
	
	private RsvJdbcDao rsvJdbc=null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudioController() {//생성자

	}

	@Override
	public void init() throws ServletException {
		System.out.println("StudioController Init()");
		
		ServletContext context = getServletContext();
		
		String driver = context.getInitParameter("jdbc_driver");
		String url = context.getInitParameter("db_url");
		String userName = context.getInitParameter("db_userid");
		String password = context.getInitParameter("db_passwd");

		loginJdbc = new LoginJdbcDao(driver, url, userName, password);
		studioJdbc= new StudioJdbcDao(driver, url, userName, password);
		professorJdbc= new ProfessorJdbcDao(driver, url, userName, password);
		manJdbc = new ManagerJdbcDao(driver, url, userName, password);
		rsvJdbc= new RsvJdbcDao(driver, url, userName, password);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");

		// step #2. data processing
		String pathInfo = request.getRequestURI();
		System.out.println("StudioController-path :" + pathInfo);

		//String action = request.getParameter("action"); 
		String viewName = null;
		
		System.out.println("session : " + session);
		
		if (session == null) {
			if (pathInfo.equals("/studio")) { // 가장처음 진입페이지
				viewName = "/WEB-INF/view/login.jsp";
				
			} else if (pathInfo.equals("/studio/login")) {
				session = request.getSession(true);//세션이 존재하면 세션반환, 없으면 새로운세션생성

				String selectLoginType = request.getParameter("selectLoginType");//radio 선택된 값
				System.out.println(selectLoginType);

				int inputID = Integer.parseInt(request.getParameter("userId"));
				String inputPWD = request.getParameter("password");

				if (selectLoginType.equals("admin")) {
					System.out.println("관리자");

					Manager manager = new Manager();
					manager = manJdbc.getManager(inputID);
					
					session.setAttribute("manager", manager);
					System.out.println(manager.getManname());
					
					viewName = "/WEB-INF/view/managerMain.jsp";
					
				} else if (selectLoginType.equals("professor")) {
					System.out.println("교직원");

					Professor pro = new Professor();
					pro = loginJdbc.selectProfessor(inputID, inputPWD);

					if (pro == null) {
						session = null;
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter writer = response.getWriter();
						writer.println("<script>alert('해당 사용자 정보를 찾을 수 없습니다!'); location.href='/studio';</script>");
						writer.close();
					} else {
						// 세션 구현부
						session.setAttribute("id", inputID);
						session.setAttribute("name", pro.getProfname());
						session.setAttribute("deptno", pro.getDeptno());
						List<Studio> studios = null;
						List<String> studioLoc= null;
						studios=studioJdbc.getStudios(null);
						studioLoc=studioJdbc.getStudiosLoc();
						
						session.setAttribute("studios", studios);
						session.setAttribute("studioLoc", studioLoc);
							 			
						/* studios출력
						  	Studio [stdno=405, loc=공대, dep=2]
							Studio [stdno=202, loc=국제관, dep=1]
							Studio [stdno=203, loc=국제관, dep=1]
							Studio [stdno=305, loc=국제관, dep=1]
							Studio [stdno=601, loc=국제관, dep=2]
							Studio [stdno=202, loc=사범관, dep=1]
							Studio [stdno=203, loc=사범관, dep=2]
							Studio [stdno=305, loc=사범관, dep=3]
							Studio [stdno=405, loc=사범관, dep=4]
							Studio [stdno=202, loc=인문관, dep=4]
							Studio [stdno=203, loc=인문관, dep=4]
							Studio [stdno=305, loc=인문관, dep=4]
							==============================================
							studioLoc출력
							공대
							국제관
							사범관
							인문관
						 *  */
						viewName = "/WEB-INF/view/calendar(jsp+js).jsp";
					}
				} else {
					System.out.println("학생");

					Student std = new Student();
					std = loginJdbc.selectStudent(inputID, inputPWD);

					if (std == null) {
						session = null;
						// 자바스크립트를 이용하여 오류메시지 출력 후 해당 주소로 이동
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter writer = response.getWriter();
						writer.println("<script>alert('해당 사용자 정보를 찾을 수 없습니다!'); location.href='/studio';</script>");
						writer.close();
					} else {
						// 세션 구현부
						session.setAttribute("id", inputID);
						session.setAttribute("name", std.getStudentname());
						session.setAttribute("grade", std.getGrade());
						session.setAttribute("deptno", std.getDeptno());
						session.setAttribute("professor", std.getProfno());

						viewName = "/WEB-INF/view/calendar(jsp+js).jsp";
					}
				}
			} else if (pathInfo.equals("/studio/professor")) {
				session = request.getSession(true);//세션이 존재하면 세션반환, 없으면 새로운세션생성
				
				List<Professor> professors = null;
				professors=professorJdbc.getProfessors(null);
				
				session.setAttribute("professors", professors);
				
				viewName = "/WEB-INF/view/admin_professor.jsp";
				
			} else if (pathInfo.equals("/studio/week")) {
				viewName = "/WEB-INF/view/calendar(week).jsp";
				
			} else if (pathInfo.equals("/studio/month")) {
				viewName = "/WEB-INF/view/calendar(jsp+js).jsp";
				
			} else if (pathInfo.equals("/studio/department")) {
				viewName = "/WEB-INF/view/admin_professor.jsp";
				
			} else if (pathInfo.equals("/studio/day")) {
				session = request.getSession(true);// 세션이 존재하면 세션반환, 없으면 새로운세션생성

				List<Professor> professors = null;
				professors = professorJdbc.getProfessors(null);

				session.setAttribute("professors", professors);

				viewName = "/WEB-INF/view/dayRsv.jsp";
			}
			
		} else if (session != null){
			if (pathInfo.equals("/studio/week")) {
				viewName = "/WEB-INF/view/calendar(week).jsp";
				
			} else if (pathInfo.equals("/studio/month")) {
				viewName = "/WEB-INF/view/calendar(jsp+js).jsp";
				
			} else {
				viewName = "/WEB-INF/view/calendar(jsp+js).jsp";
			}
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
