package com.data.beans;

import java.io.Serializable;
import java.sql.ResultSet;

import com.entity.UserEntity;

public class Admin extends UserEntity implements Serializable {

	private static final long serialVersionUID = -2919909977147818820L;
	
	private String adminId;
	private String adminName;
	private String adminPwd;
	
	public Admin() {
		super("admin_users");
		this.adminId = "";
		this.adminName = "";
		this.adminPwd = "";
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
		String sql = String.format(
				"SELECT * FROM %s WHERE admin_name = '%s'",
				table_name, adminName);
		ResultSet rs = dao.getData(sql);
		if(rs != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkUser() {
		String sql = String.format(
				"SELECT * FROM %s WHERE admin_name = '%s' AND admin_pwd = '%s'",
				table_name, adminName, adminPwd);
		ResultSet rs = dao.getData(sql);
		if(rs != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insertEntity() {
		if(!isPresent()) {
			String sql = String.format(
					"INSERT INTO %s(admin_name, admin_pwd) VALUES ('%s','%s')",
					table_name, adminName, adminPwd);
			return dao.putData(sql);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("Admin : { id : %s, name : %s, password : %s} ",
				this.adminId, this.adminName, this.adminPwd);
	}

}
