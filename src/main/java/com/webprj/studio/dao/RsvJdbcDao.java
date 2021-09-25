package com.webprj.studio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webprj.di.entity.Reservation;

public class RsvJdbcDao implements RsvDao{

	private String driver;
	private String url;
	private String userName;
	private String password;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public RsvJdbcDao(String driver, String url, String userName, String password) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
		
		System.out.println("RsvJdbcDao 생성자 실행됨");
	}

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, userName, password);
		
		System.out.println("RsvJdbcDao  DB연결성공");
	}

	private void disconnect() throws SQLException {
		System.out.println("RsvJdbcDao  DB연결해제");
		
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
	public Reservation getReservation(int rsvno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getReservationList(String query) {
		List<Reservation> rsvList = null;
		
		String sql = "SELECT * FROM Reservation";
		sql = sql + (query != null && !query.equals("") ? " WHERE " + query : " ORDER BY rsvno");

		try {
			connect();

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs.isBeforeFirst()) {
				rsvList = new ArrayList<Reservation>();
				while (rs.next()) {
					Reservation rsv = new Reservation();
					
					rsv.setRsvno(rs.getInt("rsvno"));
					rsv.setStudentno(rs.getInt("studentno"));
					rsv.setProfno(rs.getInt("profno"));
					rsv.setStudiono(rs.getInt("studiono"));
					rsv.setStudioloc(rs.getString("studioloc"));
					rsv.setManno(rs.getInt("manno"));
					rsv.setDep(rs.getString("dep"));
					rsv.setRsvDate(rs.getDate("rsvDate"));
					rsv.setStartTime(rs.getDate("sTime"));
					rsv.setEndTime(rs.getDate("eTime"));
					
					rsvList.add(rsv);
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

		return rsvList;
	}

	@Override
	public int insertReservation(Reservation rsv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReservation(Reservation rsv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReservation(int rsvno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
