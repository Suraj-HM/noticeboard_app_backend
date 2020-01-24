package com.data.beans;

import java.io.Serializable;
import java.sql.ResultSet;

import com.entity.Entity;

public class HeadOfDept extends Entity implements Entity.UserEntity , Serializable {

	private static final long serialVersionUID = -936553351779071760L;
	
	private String hodId;
	private String hodName;
	private String hodPwd;
	private String hodEmail;
	private String hodDeptId;
	
	public HeadOfDept() {
		super("head_of_dept");
		this.hodId = "";
		this.hodName = "";
		this.hodPwd = "";
		this.hodEmail = "";
		this.hodDeptId = "";
	}
	
	public HeadOfDept(String hodId, String hodName, String hodPwd, String hodEmail, String hodDeptId) {
		super("head_of_dept");
		this.hodId = hodId;
		this.hodName = hodName;
		this.hodPwd = hodPwd;
		this.hodEmail = hodEmail;
		this.hodDeptId = hodDeptId;
	}
	
	public String getHodId() { return hodId; }
	public void setHodId(String hodId) { this.hodId = hodId; }
	public String getHodName() { return hodName; }
	public void setHodName(String hodName) { this.hodName = hodName; }
	public String getHodPwd() { return hodPwd; }
	public void setHodPwd(String hodPwd) { this.hodPwd = hodPwd; }
	public String getHodEmail() { return hodEmail; }
	public void setHodEmail(String hodEmail) { this.hodEmail = hodEmail; }
	public String getHodDeptId() { return hodDeptId; }
	public void setHodDeptId(String hodDeptId) { this.hodDeptId = hodDeptId; }
	public static long getSerialversionuid() { return serialVersionUID; }

	@Override
	public boolean isPresent() {
		String sql = String.format(
				"SELECT * FROM %s WHERE hod_email = '%s'",
				table_name, hodEmail);
		ResultSet rs = dao.getData(sql);
		if(rs != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkUser() {
		String sql = String.format(
				"SELECT * FROM %s WHERE hod_email = '%s' AND hod_pwd = '%s'",
				table_name, hodEmail, hodPwd);
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
					"INSERT INTO %s(hod_name, hod_pwd, hod_email, hod_dept_id) VALUES ('%s','%s','%s','%s')",
					table_name, hodName, hodPwd, hodEmail, hodDeptId);
			return dao.putData(sql);
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("HOD : { id: %s, name : %s, email : %s, dept_id : %s , password : %s}", 
				this.hodId, this.hodName, this.hodEmail, this.hodDeptId, this.hodPwd);
	}

	@Override
	public boolean setAllFields() {
		// TODO Auto-generated method stub
		return false;
	}

}
