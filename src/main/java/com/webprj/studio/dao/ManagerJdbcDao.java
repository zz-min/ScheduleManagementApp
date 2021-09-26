package com.webprj.studio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webprj.di.entity.Manager;


public class ManagerJdbcDao implements ManagerDao {
	private String driver;
	private String url;
	private String userName;
	private String password;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public ManagerJdbcDao(String driver, String url, String userName, String password) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
		
		System.out.println("ManagerJDBCDao 생성자 실행됨");
	}

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, userName, password);
		
		System.out.println("ManagerJDBCDao  DB연결성공");
	}

	private void disconnect() throws SQLException {
		System.out.println("ManagerJDBCDao  DB연결해제");
		
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
	public Manager getManager(int manno) {
		Manager manager = null;
		
		String sql = "SELECT MANNAME,DEPTNO FROM MANAGER WHERE MANNO = ?";
		
		try {
			connect();
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, manno);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				manager = new Manager();
				manager.setManname(rs.getString("MANNAME"));
				manager.setDeptno(rs.getInt("DEPTNO"));
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
		
		return manager;
	}

	@Override
	public List<Manager> getManagerList(String query) {
		List<Manager> managers=null;
		
		String sql = "SELECT manno,manname,deptno FROM Manager";
		sql = sql + (query != null && !query.equals("") ? " WHERE " + query : " ORDER BY manno");

		try {
			connect();

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs.isBeforeFirst()) {
				managers = new ArrayList<Manager>();
				while (rs.next()) {
					Manager m = new Manager();
					m.setManno(rs.getInt("manno"));
					m.setManname(rs.getString("manname"));
					m.setDeptno(rs.getInt("deptno"));

					managers.add(m);
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
		
		
		return managers;
	}

}
