package com.entity;

import com.dao.DAO;
import com.database.DatabaseConnction;

public abstract class UserEntity {
	protected DAO dao;
	protected String table_name;
	
	public UserEntity() {
		this.dao = new DatabaseConnction(); 
	}
	
	public UserEntity(String table_name) {
		this.dao = new DatabaseConnction();
		this.table_name = table_name;
	}
	
	public abstract boolean isPresent();
	public abstract boolean checkUser();
	public abstract boolean insertEntity();
	
	@Override
	protected void finalize() throws Throwable {
		dao.closeConnection();
		super.finalize();
	}
}
