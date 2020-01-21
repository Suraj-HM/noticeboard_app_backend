package com.entity;

import com.dao.DAO;
import com.database.DatabaseConnction;

public abstract class Entity {
	protected DAO dao;
	protected String table_name;
	
	public Entity() {
		this.dao = new DatabaseConnction(); 
	}
	
	public Entity(String table_name) {
		this.dao = new DatabaseConnction();
		this.table_name = table_name;
	}
	
	public abstract boolean isPresent();
	public abstract boolean insertEntity();
	
	@Override
	protected void finalize() throws Throwable {
		dao.closeConnection();
		super.finalize();
	}
}
