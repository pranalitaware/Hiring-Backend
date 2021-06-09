package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lti.enums.Level;

@Entity
@Table(name="tbl_rate_candidate")
public class RateCandidate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq2")
	@SequenceGenerator(sequenceName = "ref_seq2", initialValue = 1, allocationSize = 1, name="seq2")	
	@Column(name="rid")
	private long rid;
	
	private long uid;
	
	private long jid;
	
	private String commuSkill;
	
	private String techSkill;
	
	private String reasoningSkill;
	
	private char rating;
	
	private String remarks;
	
	private Level level;
	
	
}
