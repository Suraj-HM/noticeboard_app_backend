package com.data.beans;

import java.io.Serializable;

import com.entity.UserEntity;

public class Admin extends UserEntity implements Serializable {

	private static final long serialVersionUID = -2919909977147818820L;
	
	private String adminId;
	private String adminName;
	private String adminPwd;
	
	public Admin() {
		super("admin_users");
	}
	
	public Admin(String adminId, String adminName, String adminPwd) {
		super("admin_users");
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
