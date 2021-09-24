package com.webprj.studio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.webprj.di.entity.Manager;

import ManagerDao.ManagerDao;

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
		
		String sql = "SELECT * FROM MANAGER WHERE MANNO = ?";
		
		try {
			connect();
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, manno);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				manager = new Manager();
				manager.setManno(rs.getInt("MANNO"));
				manager.setManname(rs.getString("MANNAME"));
				manager.setPwd(rs.getString("PWD"));
				manager.setDep(rs.getString("DEP"));
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
	public int insertManager(Manager manager) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateManager(Manager manager) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteManager(int manno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
