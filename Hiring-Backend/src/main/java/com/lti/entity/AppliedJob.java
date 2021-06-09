package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_applied_job")
public class AppliedJob {

	private long uid;
	private long jid;
}
