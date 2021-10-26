package com.webprj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webprj.di.Content;

public class ContentJdbcDao implements ContentDao {
	private String driver;
	private String url;
	private String userName;
	private String password;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public ContentJdbcDao(String driver, String url, String userName, String password) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
	}
	
	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, userName, password);
		
		//System.out.println("ContentJdbcDao  DB연결성공");
	}

	private void disconnect() throws SQLException {
		//System.out.println("ContentJdbcDao  DB연결해제");
		
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
	public List<Content> contentList(String query) {
		List<Content> contents = null;
		
		String sql = "SELECT * FROM CONTENT";
		sql = sql + (query != null && !query.equals("") ? " WHERE " + query : " ORDER BY content_type, main_category");
		System.out.println(sql);
		//content_type, mainCategory, subCategory, content_type
		try {
			connect();

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs.isBeforeFirst()) {
				contents = new ArrayList<Content>();
				while (rs.next()) {
					Content content = new Content();
					content.setContent_seq(rs.getInt("content_seq"));
					content.setMainCategory(rs.getString("main_category"));
					content.setSubCategory(rs.getInt("sub_Category"));
					content.setContent_type(rs.getString("content_type"));

					contents.add(content);
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
		
		return contents;
	}

	@Override
	public List<String> mainContentList(String query) {
		List<String> mainContents = null;
		
		String sql = "SELECT DISTINCT main_category FROM CONTENT";
		sql = sql + (query != null && !query.equals("") ? " WHERE " + query : " ORDER BY main_category");
		System.out.println(sql);
		//content_type, mainCategory, subCategory, content_type
		try {
			connect();

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs.isBeforeFirst()) {
				mainContents = new ArrayList<String>();
				while (rs.next()) {
					String content = rs.getString("main_category");

					mainContents.add(content);
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
		
		return mainContents;
	}

	@Override
	public List<String> subContentList(String query) {
		return null;
	}

}
