package com.data.beans;

import java.io.Serializable;

import com.entity.Entity;

public class Notice extends Entity implements Serializable {

	private static final long serialVersionUID = 5366922415453065225L;
	
	private String noticeId;
	private String noticeMessage;
	private String noticeDeptId;
	
	public Notice() {
		super("notices");
		noticeId = "";
		noticeMessage = "";
		noticeDeptId = "";
	}

	public Notice(String noticeId, String noticeMessage, String noticeDeptId) {
		super("notices");
		this.noticeId = noticeId;
		this.noticeMessage = noticeMessage;
		this.noticeDeptId = noticeDeptId;
	}
	
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeMessage() {
		return noticeMessage;
	}
	public void setNoticeMessage(String noticeMessage) {
		this.noticeMessage = noticeMessage;
	}
	public String getNoticeDeptId() {
		return noticeDeptId;
	}
	public void setNoticeDeptId(String noticeDeptId) {
		this.noticeDeptId = noticeDeptId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean isPresent() {
		String sql = String.format("SELECT id FROM %s WHERE id = %s",
				table_name ,noticeId);
		if(dao.getData(sql) == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean insertEntity() {
		String sql = String.format("INSERT INTO %s(id, message, notice_dept_id) VALUES ('%s', '%s', '%s')",
				table_name ,noticeId, noticeMessage, noticeDeptId);
		return dao.putData(sql);
	}
	
	@Override
	public String toString() {
		return String.format("Notice : { id : %s, message : %s, dept_id : %s }",
				noticeId, noticeMessage, noticeDeptId);
	}
	
}
