package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_panellist")
public class Panellist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq2")
	@SequenceGenerator(sequenceName = "ref_seq2", initialValue = 10008000, allocationSize = 1, name="seq2")	
	@Column(name="p_id")
	private long pid;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="grade")
	private String grade;

	//@OneToOne(mappedBy = "intId.panellist",cascade = CascadeType.ALL)
	//private Interview interview;

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	/*public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}*/
	
}
