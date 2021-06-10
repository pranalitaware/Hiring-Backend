package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_login_detail")
public class Login {

	@OneToOne
	@JoinColumn(name="uid")
	private Registration registration;
	
	@Id	
	@Column(name="customer_id")
	private long customerId;
	
	@Column(name="password")
	private String password;

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
