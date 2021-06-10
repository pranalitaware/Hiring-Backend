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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}
