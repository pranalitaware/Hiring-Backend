package com.lti.model;

import com.lti.model.Status;

public class RegisterStatus extends Status {

	private long userId;

	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
}