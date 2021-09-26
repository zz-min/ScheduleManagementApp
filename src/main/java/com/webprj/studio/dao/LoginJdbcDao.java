package com.webprj.studio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.webprj.di.entity.Manager;
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
		String sql = "select * from PROFESSOR where PROFNO = ? AND PWD = ?";
		try {
			connect();
			
			stmt =  conn.prepareStatement(sql);
			stmt.setInt(1, profno);
			stmt.setString(2, pwd);
			
			rs = stmt.executeQuery();

			if (rs.next()) {
				pf = new Professor();
				pf.setProfno(rs.getInt("profno"));
				pf.setProfname(rs.getString("profname"));
				pf.setMajorno(rs.getInt("majorno"));
				pf.setPwd(rs.getString("pwd"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
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
		String sql = "select * from STUDENT where STUDNO = ? AND PWD = ?";
		try {
			connect();
			
			stmt =  conn.prepareStatement(sql);
			stmt.setInt(1, studno);
			stmt.setString(2, pwd);
			
			rs = stmt.executeQuery();

			if (rs.next()) {
				sd = new Student();
				sd.setStudentno(rs.getInt("studentno"));
				sd.setStudentname(rs.getString("studentname"));
				sd.setGrade(rs.getInt("grade"));
				sd.setMajorno(rs.getInt("majorno"));
				sd.setPwd(rs.getString("pwd"));
				sd.setProfno(rs.getInt("prof"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				disconnect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sd;
	}

	@Override
	public Manager selectManager(int manno, String pwd) {
		Manager mg = null;
		String sql = "select * from MANAGER where manno = " + manno + "AND PWD = " + pwd;
		try {
			connect();

			stmt =  conn.prepareStatement(sql);
			stmt.setInt(1, manno);
			stmt.setString(2, pwd);
			
			rs = stmt.executeQuery();

			if (rs.next()) {
				mg = new Manager();
				mg.setManno(rs.getInt("manno"));
				mg.setManname(rs.getString("manname"));
				mg.setPwd(rs.getString("pwd"));
				mg.setDeptno(rs.getInt("majorno"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				disconnect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mg;
	}

}
