package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lti.compoundKey.Compound;

@Entity
@Table(name="tbl_interview")
public class Interview {

	
	@EmbeddedId
	@Column(name="int_id")
	private Compound intId;
	
}
