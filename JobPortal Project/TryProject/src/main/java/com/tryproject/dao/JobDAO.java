package com.tryproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.tryproject.exception.JobException;
import com.tryproject.pojo.Job;

public class JobDAO extends DAO{
	
	public Job create(Job job)
	           throws JobException {
	       try {
	           begin();            
	           getSession().save(job);    
	           commit();
	           return job;
	       } catch (HibernateException e) {
	           rollback();
	           //throw new AdException("Could not create job", e);
	           throw new JobException("Exception while creating job: " + e.getMessage());
	       }
	   }

	   public void delete(Job job)throws JobException {
	       try {
	           begin();
	           getSession().delete(job);
	           commit();
	       } catch (HibernateException e) {
	           rollback();
	           throw new JobException("Could not delete job", e);
	       }
	   }
	   //Trying code of list of specefic company user
	   
	   public List<Job> specificList(String userID) throws JobException{
	       
	       try {
	           begin();
	           Query q = getSession().createQuery("from Job where company.userID = :userID");
	           q.setString("userID", userID);
	           List<Job> jobs = q.list();
	           commit();
	           return jobs;
	       } catch (HibernateException e) {
	           rollback();
	           throw new JobException("Could not find specific job list", e);
	       }
	       
	   }
	   
	   //code ends here
	   
	   
	   public List<Job> list() throws JobException{
	       
	       try {
	           begin();
	           Query q = getSession().createQuery("from Job");
	           List<Job> jobs = q.list();
	           commit();
	           return jobs;
	       } catch (HibernateException e) {
	           rollback();
	           throw new JobException("Could not delete job", e);
	       }
	       
	   }
	
	   //trying get method using job id 
	   public Job get(Long job) throws JobException{
		   try {
			   begin();
	            Query q = getSession().createQuery("from Job where jobID= :jobID");
	            q.setLong("jobID",job);
	            Job j= (Job) q.uniqueResult();
	            commit();
	            return j;
	        } catch (HibernateException e) {
	            rollback();
	            throw new JobException("Could not get job ", e);
	        }
	   }
	   //ends here
	   
	 
	
}
