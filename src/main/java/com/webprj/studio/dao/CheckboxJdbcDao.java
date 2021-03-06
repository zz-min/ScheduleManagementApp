package com.webprj.studio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.webprj.di.entity.Checkbox;

public class CheckboxJdbcDao {
	private String driver;
	private String url;
	private String userName;
	private String password;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public CheckboxJdbcDao(String driver, String url, String userName, String password) {
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

	public Checkbox getCheckedBox() {
		Checkbox checkBox = new Checkbox();

		String sql = "SELECT * FROM CHECKBOX";

		try {
			connect();

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					
					checkBox.setCheckedbox((new Gson()).fromJson(rs.getString("CHECKEDBOX"), String[].class));

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

		return checkBox;
	}

	public int insertCheckBox(Checkbox chBox) {
		int result = 0;
		int count = 0;

		String sql = "INSERT INTO CHECKBOX VALUES (?)";
		String sql2 = "TRUNCATE TABLE CHECKBOX";
		String sql3 = "SELECT COUNT(*) FROM CHECKBOX";
		try {
			connect();

			stmt = conn.prepareStatement(sql3);
			rs = stmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count >= 1) {
				stmt = conn.prepareStatement(sql2);
				stmt.executeUpdate();
			}

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, (new Gson()).toJson(chBox.getCheckedbox()));

			result = stmt.executeUpdate();

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

		return result;
	}
	
}