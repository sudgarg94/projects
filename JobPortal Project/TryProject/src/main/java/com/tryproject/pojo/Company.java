package com.tryproject.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="company_table")
@PrimaryKeyJoinColumn(name="userID")
public class Company extends User{
	
	@Column(name="companyName")
	private String companyName;
	

	public Company(String companyName) {
		this.companyName = companyName;
	}

	public Company() {
	
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	
	
	


	

}
