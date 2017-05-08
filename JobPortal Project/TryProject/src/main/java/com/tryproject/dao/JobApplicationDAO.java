package com.tryproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.tryproject.exception.JobException;
import com.tryproject.pojo.Job;
import com.tryproject.pojo.JobApplication;
import com.tryproject.pojo.JobSeeker;

public class JobApplicationDAO extends DAO{
	
	public JobApplication create(JobApplication jobApplication)throws JobException{
		
		try{
			begin();
			System.out.println("inside job app dao 1");
			getSession().merge(jobApplication);
			System.out.println("inside job app dao 2");
			commit();
			close();
			return jobApplication;
			
		}
		catch (HibernateException e) {
	           rollback();
	           //throw new AdException("Could not create job", e);
	           throw new JobException("Exception while creating job: " + e.getMessage());
	       }
		
		
	}
	
	//List of all job applications
	
	 public List<JobApplication> list() throws JobException{
	       
	       try {
	           begin();
	           Query q = getSession().createQuery("from JobApplication");
	           List<JobApplication> jobApplication = q.list();
	           commit();
	           return jobApplication;
	       } catch (HibernateException e) {
	           rollback();
	           throw new JobException("Could not get list of job application", e);
	       }
	       
	   }
	
	//ends here
	
	public List<JobSeeker> getApplicationUsers(String jobID) throws JobException{
	       
	       try {
	           begin();
	           System.out.println("inside get app method");
	           Query q = getSession().createQuery("from JobApplication where jobID = :jobID");
	           q.setString("jobID", jobID);
	           List<JobApplication> jobApplication = q.list();
	           for(JobApplication ja : jobApplication){
	        	   System.out.println("number of applications with that job" +ja);
	           }
	           System.out.println("inside get app method 2");
	           List<JobSeeker> js = new ArrayList<JobSeeker>();
	           for(JobApplication jobApp : jobApplication){
	        	   JobSeeker j = jobApp.getJobseeker();
	        	   js.add(j);
	           }
	           for(JobSeeker jss : js){
	        	   System.out.println("number of jobs seekers with that job" +jss);
	           }
	           commit();
	           return js;
	       } catch (HibernateException e) {
	           rollback();
	           throw new JobException("Could not find specific job list", e);
	       }
	       
	   }
	
	//getting application itself
	public List<JobApplication> getApplication(String jobID) throws JobException{
	       
	       try {
	           begin();
	           System.out.println("inside get app method");
	           Query q = getSession().createQuery("from JobApplication where jobID = :jobID");
	           q.setString("jobID", jobID);
	           List<JobApplication> jobApplication = q.list();
//	           for(JobApplication ja : jobApplication){
//	        	   System.out.println("number of applications with that job" +ja);
//	           }
	           //System.out.println("inside get app method 2");
	           //List<JobSeeker> js = new ArrayList<JobSeeker>();
	           //for(JobApplication jobApp : jobApplication){
	        	   //JobSeeker j = jobApp.getJobseeker();
	        	   //js.add(j);
	           //}
//	           for(JobSeeker jss : js){
//	        	   System.out.println("number of jobs seekers with that job" +jss);
//	           }
	           commit();
	           return jobApplication;
	       } catch (HibernateException e) {
	           rollback();
	           throw new JobException("Could not find specific job list", e);
	       }
	       
	   }
	//ends here
	
	//getting job applications applied by job seeker
	public List<JobApplication> getApplicationsApplied(String userID) throws JobException{
	       
	       try {
	           begin();
	           System.out.println("inside get app method");
	           Query q = getSession().createQuery("from JobApplication where userID = :userID");
	           q.setString("userID", userID);
	           List<JobApplication> jobApplication = q.list();
	           commit();
	           return jobApplication;
	       } catch (HibernateException e) {
	           rollback();
	           throw new JobException("Could not find specific job list", e);
	       }
	       
	   }
	//ends here
	//getting count
	public long getCount() throws JobException{
	       
	       try {
	           begin();
	           System.out.println("inside get app method");
	           Query q = getSession().createQuery("Select count(*) from JobApplication");
	           long count = (Long) q.uniqueResult();
	           commit();
	           return count;
	       } catch (HibernateException e) {
	           rollback();
	           throw new JobException("Could not find count", e);
	       }
	       
	   }
	//ends here
}
