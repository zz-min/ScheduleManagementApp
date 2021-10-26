package com.webprj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginJdbcDao implements LoginDao {
	//jdbcFormat jf=null;
	
	private String driver;
	private String url;
	private String userName;
	private String password;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public LoginJdbcDao(String driver, String url, String userName, String password) {
		/*
		 * jf=new jdbcFormat(driver,url,userName,password); this.conn=jf.getConn();
		 * this.stmt=jf.getStmt(); this.rs=jf.getRs();
		 */
		
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
		
		//System.out.println("NEW LoginJDBCDao 생성자 실행됨");
	}
	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, userName, password);
		
		//System.out.println("RsvJdbcDao  DB연결성공");
	}

	private void disconnect() throws SQLException {
		//System.out.println("RsvJdbcDao  DB연결해제");
		
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
	public boolean loginAvailability(String id, String pwd) {
		boolean TF=false;
		String sql = "select * from MAIN where user_id = ? AND PWD = ?";
		try {
			connect();
			
			stmt =  conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pwd);
			
			rs = stmt.executeQuery();

			if (rs.next()) {
				TF=true;
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
		return TF;
	}
}
