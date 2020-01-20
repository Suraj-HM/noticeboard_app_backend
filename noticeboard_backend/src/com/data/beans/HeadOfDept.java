package com.data.beans;

import java.io.Serializable;

import com.entity.UserEntity;

public class HeadOfDept extends UserEntity implements Serializable {

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
	
	public String getHodId() {
		return hodId;
	}

	public void setHodId(String hodId) {
		this.hodId = hodId;
	}

	public String getHodName() {
		return hodName;
	}

	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	public String getHodPwd() {
		return hodPwd;
	}

	public void setHodPwd(String hodPwd) {
		this.hodPwd = hodPwd;
	}

	public String getHodEmail() {
		return hodEmail;
	}

	public void setHodEmail(String hodEmail) {
		this.hodEmail = hodEmail;
	}

	public String getHodDeptId() {
		return hodDeptId;
	}

	public void setHodDeptId(String hodDeptId) {
		this.hodDeptId = hodDeptId;
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
	
	@Override
	public String toString() {
		
		return String.format("HOD : name : %s, email : %s, dept_id:%s", this.hodName, this.hodEmail, this.hodDeptId);
	}

}
