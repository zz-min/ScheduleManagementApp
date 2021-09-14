package com.webprj.studio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.webprj.di.entity.Reservation;

public class rsvDao implements Dao {
	private String jdbcDriver;
	private String dbUrl;
	private String dbUserId;
	private String dbPasswd;

	private Connection conn = null;
	private Statement stmt = null;

	public rsvDao() {
	}

	public rsvDao(String jdbcDriver, String dbUrl, String dbUserId, String dbPasswd) {
		this.jdbcDriver = jdbcDriver;
		this.dbUrl = dbUrl;
		this.dbUserId = dbUserId;
		this.dbPasswd = dbPasswd;
	}

	@Override
	public void connectDB() throws ClassNotFoundException, SQLException {
		Class.forName(jdbcDriver);
		conn = DriverManager.getConnection(dbUrl, dbUserId, dbPasswd);
		if (conn != null) {
			stmt = conn.createStatement();
		}
	}

	@Override
	public void disconnectDB() throws SQLException{
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}
	
	public List<Reservation> getRsvList() throws SQLException, ClassNotFoundException {
		ArrayList<Reservation> rsvList = null;
		connectDB();
		String sql = "select * from Reservation ORDER BY stdono";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.isBeforeFirst()) {
			rsvList = new ArrayList<Reservation>();
			while (rs.next()) {
				Reservation rsv = new Reservation();
				rsv.setRsvno(rs.getInt("rsvno"));
		
				
				rsvList.add(rsv);
			}
		}
		rs.close();
		disconnectDB();
		return rsvList;
	}

}
