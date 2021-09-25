package com.webprj.studio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webprj.di.entity.Student;

public class StudentJdbctDao implements StudentDao {

	private String driver;
	private String url;
	private String userName;
	private String password;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public StudentJdbctDao(String driver, String url, String userName, String password) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;

		System.out.println("StudenJdbctDao 생성자 실행됨");
	}

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, userName, password);

		System.out.println("StudenJdbctDao DB연결성공");
	}

	private void disconnect() throws SQLException {
		System.out.println("StudenJdbctDao DB연결해제");

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
	public List<Student> getStudentList(String query) {
		List<Student> studentList = null;
		
		String sql = "SELECT profno,profname,deptno FROM Student";
		sql = sql + (query != null && !query.equals("") ? " WHERE " + query : " ORDER BY profno");

		try {
			connect();

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs.isBeforeFirst()) {
				studentList = new ArrayList<Student>();
				while (rs.next()) {
					Student std = new Student();
					std.setStudentno(rs.getInt("studentno"));
					std.setStudentname(rs.getString("studentname"));
					std.setGrade(rs.getInt("grade"));
					std.setDeptno(rs.getInt("deptno"));
					std.setPwd(rs.getString("pwd"));
					std.setProfno(rs.getInt("profno"));

					studentList.add(std);
				}
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

		return studentList;
	}

	@Override
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

}
