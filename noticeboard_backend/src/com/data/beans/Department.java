package com.data.beans;

import java.io.Serializable;
import java.util.ArrayList;

import com.entity.Entity;

/*
 * to be only used as a static class
 *  Try not to instantiate as the implementation is not complete
*/


public class Department extends Entity implements Serializable {

	private static final long serialVersionUID = -6901910476115327284L;
	
	public Department() {
		this.table_name = "deparments";
	}
	
	@Override
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertEntity() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAllFields() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static ArrayList<Department> getAllDepts() {
		
		return null;
	}

}
