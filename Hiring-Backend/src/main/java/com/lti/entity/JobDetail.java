package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_job_detail")
public class JobDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq3")
	@SequenceGenerator(sequenceName = "ref_seq3", initialValue = 1, allocationSize = 1, name="seq3")	
	@Column(name="job_id")
	private long jobId;
	
	@Column(name="job_role")
	private String jobRole;
	
	@Column(name="proj_name")
	private String projName;
	
	@Column(name="experience")
	private long experience;
	
	@Column(name="skill_set")
	private String skillSet;
}
