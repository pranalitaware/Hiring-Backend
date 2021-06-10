package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lti.enums.Title;

@Entity
@Table(name="tbl_registration_hire")
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	@SequenceGenerator(sequenceName = "ref_seq1", initialValue = 1, allocationSize = 1, name="seq1")	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="title")
	private Title title;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="mobile_number")
	private long mobileNo;
	
	@Column(name="email_id")
	private String emailId;

	@Column(name="dob")
	private LocalDate dateOfBirth;
	
	@Column(name="skill_set")
	private String skillSet;

	@Column(name="resume")
	private String resume;
	
	@OneToOne(mappedBy = "registration",cascade = CascadeType.ALL)
	private Login login;
}
