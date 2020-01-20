package com.data.beans;

import java.io.Serializable;

import com.entity.UserEntity;

public class Department extends UserEntity implements Serializable {

	private static final long serialVersionUID = -6901910476115327284L;

	@Override
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertEntity() {
		// TODO Auto-generated method stub
		return false;
	}

}
