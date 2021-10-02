package com.webprj.Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webprj.studio.controller.HandlerMapping;
import com.webprj.studio.dao.LoginDao;
import com.webprj.studio.dao.LoginJdbcDao;
import com.webprj.studio.dao.ManagerDao;
import com.webprj.studio.dao.ManagerJdbcDao;
import com.webprj.studio.dao.ProfessorDao;
import com.webprj.studio.dao.ProfessorJdbcDao;
import com.webprj.studio.dao.RsvDao;
import com.webprj.studio.dao.RsvJdbcDao;
import com.webprj.studio.dao.StudentDao;
import com.webprj.studio.dao.StudentJdbcDao;
import com.webprj.studio.dao.StudioDao;
import com.webprj.studio.dao.StudioJdbcDao;
import com.webprj.studio.service.StudioService;
import com.webprj.studio.service.StudioServiceImpl;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudioService studioService = null;
	private HandlerMapping mapper = null;
	private HttpSession session = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
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

		LoginDao loginJdbc = new LoginJdbcDao(driver, url, userName, password);
		ManagerDao manJdbc = new ManagerJdbcDao(driver, url, userName, password);
		ProfessorDao professorJdbc = new ProfessorJdbcDao(driver, url, userName, password);
		StudentDao studentJdbc = new StudentJdbcDao(driver, url, userName, password);
		StudioDao studioJdbc = new StudioJdbcDao(driver, url, userName, password);
		RsvDao rsvJdbc = new RsvJdbcDao(driver, url, userName, password);

		studioService = new StudioServiceImpl(loginJdbc,manJdbc,professorJdbc,studentJdbc,studioJdbc,rsvJdbc);

		mapper = new HandlerMapping();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");

		String path = request.getRequestURI();
		String viewName = null;
		
		session = request.getSession(false);//세션이 존재하면 세션반환, 없으면 NULL반환

		// step #2. data processing ==> dispatch request to controller
		Controller handler = mapper.getHandler(path);

		if (handler != null) {
			viewName = handler.handleRequest(request, response, studioService);
		}

		if (viewName == null) {
			viewName = "error.jsp";
		}

		// step #3. output processing results
		if (viewName != null) {
			session = request.getSession(false);//세션이 존재하면 세션반환, 없으면 NULL반환
			
			viewName = viewName.trim();//공백제거함

			viewName = "/WEB-INF/view/" + viewName;
			System.out.println("viewName : "+viewName);

			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request, response);
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
