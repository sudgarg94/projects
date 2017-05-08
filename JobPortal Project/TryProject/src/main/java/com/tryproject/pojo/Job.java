package com.tryproject.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="job_table")
public class Job {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="jobID", unique = true , nullable=false)
    private long id;
	
	@Column(name="title")
    private String title;
	
	@Column(name="message")
    private String message;
	
	@Column(name="status")
    private String status;
	
	@ManyToOne
	private Company company;
	
	@OneToMany(mappedBy = "job")
	private Set<JobApplication> jobApplication = new HashSet<JobApplication>(); 
	
	
	@Transient
	int postedBy;

    public Job(String title, String message, Company company) {
        this.title = title;
        this.message = message;
        this.company = company;
    }
    
    public Job(){	
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(int postedBy) {
		this.postedBy = postedBy;
	}

	public Set<JobApplication> getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(Set<JobApplication> jobApplication) {
		this.jobApplication = jobApplication;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
    
    

		
}
