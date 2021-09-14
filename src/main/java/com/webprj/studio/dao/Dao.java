package com.webprj.studio.dao;

import java.sql.SQLException;

public interface Dao {

	void connectDB() throws ClassNotFoundException, SQLException;

	void disconnectDB() throws SQLException;

}
