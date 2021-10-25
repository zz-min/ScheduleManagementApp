package com.webprj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginJdbcDao implements LoginDao {
	jdbcFormat jf=null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public LoginJdbcDao(String driver, String url, String userName, String password) {
		jf=new jdbcFormat(driver,url,userName,password);
		this.conn=jf.getConn();
		this.stmt=jf.getStmt();
		this.rs=jf.getRs();
		
		System.out.println("NEW LoginJDBCDao 생성자 실행됨");
	}

	@Override
	public boolean loginAvailability(String id, String pwd) {
		boolean TF=false;
		String sql = "select * from MAIN where user_id = ? AND PWD = ?";
		try {
			jf.connect();
			
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
					jf.disconnect();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return TF;
	}
}
