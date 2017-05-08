package com.tryproject.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name="jobapplication_table")
public class JobApplication {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="jobApplicationID", unique = true , nullable=false)
    private long id;
	
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="userID")
	private JobSeeker jobseeker;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="jobID")
	private Job job;
	
	//additional fields
	@Column(name="resume")
	private String resume;
	
	@Transient
	private CommonsMultipartFile photo; 

	public JobSeeker getJobseeker() {
		return jobseeker;
	}

	public void setJobseeker(JobSeeker jobseeker) {
		this.jobseeker = jobseeker;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CommonsMultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}

	
	
	
	
	
	
	
	
	
}
