package com.webprj.studio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.webprj.di.entity.Professor;
import com.webprj.di.entity.Student;


public class LoginJdbcDao implements LoginDao {
	private String driver;
	private String url;
	private String userName;
	private String password;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public LoginJdbcDao(String driver, String url, String userName, String password) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
		
		System.out.println("LoginJDBCDao 생성자 실행됨");
	}

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, userName, password);
		
		System.out.println("LoginJDBCDao  DB연결성공");
	}

	private void disconnect() throws SQLException {
		System.out.println("LoginJDBCDao  DB연결해제");
		
		if (rs != null && !rs.isClosed()) {
			rs.close();
			rs = null;
		}
		if (stmt != null && !stmt.isClosed()) {
			stmt.close();
			stmt = null;
		}
		if (conn != null && !conn.isClosed()) {
			conn.close();
			conn = null;
		}
	}

	@Override
	public Professor selectProfessor(int profno, String pwd) {
		Professor pf = null;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			connect();

			// create Statement object
			stmt = conn.createStatement();

			// execute SQL query
			String sql = "select * from PROFESSOR where PROFNO = " + profno + "AND PWD = " + pwd;
			rs = stmt.executeQuery(sql);

			// process results
			if (rs.next()) {
				pf = new Professor();
				pf.setProfno(rs.getInt("profno"));
				pf.setName(rs.getString("profname"));
				pf.setDeptno(rs.getInt("deptno"));
				pf.setPwd(rs.getString("pwd"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				disconnect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return pf;
	}

	@Override
	public Student selectStudent(int studno, String pwd) {
		Student sd = null;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			connect();

			// create Statement object
			stmt = conn.createStatement();

			// execute SQL query
			String sql = "select * from STUDENT where STUDNO = " + studno + "AND PWD = " + pwd;
			rs = stmt.executeQuery(sql);

			// process results
			if (rs.next()) {
				sd = new Student();
				sd.setStudno(rs.getInt("studentno"));
				sd.setName(rs.getString("studname"));
				sd.setGrade(rs.getInt("grade"));
				sd.setDeptno(rs.getInt("deptno"));
				sd.setPwd(rs.getString("pwd"));
				sd.setProfessor(rs.getInt("prof"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				disconnect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return sd;
	}

}
