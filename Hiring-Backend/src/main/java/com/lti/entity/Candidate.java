package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lti.enums.SelStatus;

@Entity
@Table(name="tbl_candidate")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	@SequenceGenerator(sequenceName = "ref_seq1", initialValue = 1, allocationSize = 1, name="seq1")	
	@Column(name="c_id")
	private long cid;
	
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
	
	@Column(name="resume")
	private String resume;
	
	@Column(name="feedback")
	private String feedback;
	
	@Column(name="rating")
	private long rating;
	
	@Column(name="status")
	private SelStatus selStatus;
	
	@Column(name="levels")
	private long level;
	
	
	@ManyToOne
	@JoinColumn(name="p_id")
	private Panellist panellist;

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
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

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public long getRating() {
		return rating;
	}

	public void setRating(long rating) {
		this.rating = rating;
	}

	public SelStatus getSelStatus() {
		return selStatus;
	}

	public void setSelStatus(SelStatus selStatus) {
		this.selStatus = selStatus;
	}

	public long getLevel() {
		return level;
	}

	public void setLevel(long level) {
		this.level = level;
	}

	public Panellist getPanellist() {
		return panellist;
	}

	public void setPanellist(Panellist panellist) {
		this.panellist = panellist;
	}
	
}
