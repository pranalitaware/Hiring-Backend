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
}
