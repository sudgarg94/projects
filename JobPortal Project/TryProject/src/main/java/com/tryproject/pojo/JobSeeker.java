package com.tryproject.pojo;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="jobsekker_table")
@PrimaryKeyJoinColumn(name="userID")
public class JobSeeker extends User{
	
	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;
	
	@Column(name="emailID")
	private String emailID;
	
	@OneToMany(mappedBy = "jobseeker")
	private Set<JobApplication> jobApplication = new HashSet<JobApplication>();
	
	
	public JobSeeker(String firstName, String lastName) {
		this.firstName= firstName;
		this.lastName = lastName;
		
	}
	
	public JobSeeker() {
	
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<JobApplication> getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(Set<JobApplication> jobApplication) {
		this.jobApplication = jobApplication;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	
	
	
	
	
	

}
