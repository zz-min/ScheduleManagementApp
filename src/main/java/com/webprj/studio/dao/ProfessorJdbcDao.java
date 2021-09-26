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
		Professor p=null;
		
		String sql = "SELECT profname,majorno FROM Professor WHERE profno = ?";
		
		try {
			connect();

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, profno);

			rs = stmt.executeQuery();

			p = new Professor();
			while (rs.next()) {
				p.setProfname(rs.getString("profname"));
				p.setMajorno(rs.getInt("majorno"));
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
		
		return p;
	}

	@Override
	public List<Professor> getProfessorList(String query) {
		List<Professor> professors = null;
		
		String sql = "SELECT profno,profname,majorno FROM Professor";
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
					professor.setMajorno(rs.getInt("majorno"));

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


}
