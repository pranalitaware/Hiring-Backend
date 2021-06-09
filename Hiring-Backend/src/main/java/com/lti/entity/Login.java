package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_login_detail")
public class Login {

	@Column(name="uid")
	private long uid;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
}
