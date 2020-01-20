package com.dao;

import java.sql.ResultSet;

public interface DAO {
	public boolean putData(String sql);
	public ResultSet getData(String sql);
	public void closeConnection();
}
