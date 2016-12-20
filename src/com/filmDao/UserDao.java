package com.filmDao;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
	public boolean login(Connection conn, String name) throws SQLException;
}
