package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dao.DAO;

public class DatabaseConnction implements DAO {
	
	private String schema;
	private String user;
	private String password;
	private String url;
	
	private Connection conn;
	private Statement smt;
	
	public DatabaseConnction() {
		this.schema = "college_notice_board";
		this.user = "root";
		this.password = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			url = String.format("jdbc:mysql://localhost:3306/%s", this.schema);
			this.conn = DriverManager.getConnection(this.url, this.user, this.password);
			this.smt = conn.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DatabaseConnction(String schema, String user, String password) {
		this.schema = schema;
		this.user = user;
		this.password = password;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url = String.format("jdbc:mysql://localhost:3306/%s", this.schema);
			this.conn = DriverManager.getConnection(this.url, this.user, this.password);
			this.smt = conn.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean putData(String sql) {
		try {
			int res = smt.executeUpdate(sql);
			if(res > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ResultSet getData(String sql) {
		try {
			ResultSet rs = smt.executeQuery(sql);
			if(rs.next()) {
				return rs;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("Connection could not be closed");
			e.printStackTrace();
		}
	}
	
}
