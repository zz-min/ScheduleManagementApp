package com.webprj.studio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webprj.di.entity.Professor;

public class ProfessorJdbcDao implements ProfessorDao {
	private String driver;
	private String url;
	private String userName;
	private String password;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public ProfessorJdbcDao(String driver, String url, String userName, String password) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
		
		System.out.println("ProfessorJdbcDao 생성자 실행됨");
	}

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, userName, password);
		
		System.out.println("ProfessorJdbcDao  DB연결성공");
	}

	private void disconnect() throws SQLException {
		System.out.println("ProfessorJdbcDao  DB연결해제");
		
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
	public Professor getProfessor(int profno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> getProfessors(String query) {
		List<Professor> professors = null;
		
		String sql = "SELECT profno,profname,deptno FROM Professor";
		sql = sql + (query != null && !query.equals("") ? " WHERE " + query : " ORDER BY profno");

		try {
			connect();

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs.isBeforeFirst()) {
				professors = new ArrayList<Professor>();
				while (rs.next()) {
					Professor professor = new Professor();
					professor.setProfno(rs.getInt("profno"));
					professor.setProfname(rs.getString("profname"));
					professor.setDeptno(rs.getInt("deptno"));

					professors.add(professor);
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

		return professors;
	}

	@Override
	public int insertReservation(Professor prof) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReservation(Professor prof) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReservation(int profno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
