package com.data.beans;

import java.io.Serializable;

import com.entity.UserEntity;

public class Student extends UserEntity implements Serializable {

	private static final long serialVersionUID = -244308568422854545L;

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
