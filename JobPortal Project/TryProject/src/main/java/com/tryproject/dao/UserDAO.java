package com.tryproject.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.tryproject.exception.UserException;
import com.tryproject.pojo.Company;
import com.tryproject.pojo.JobSeeker;
import com.tryproject.pojo.User;

public class UserDAO extends DAO{
	
	public UserDAO() {
    }
	
	public Company registerCompany(Company c) throws UserException {
        try {
            begin();
            System.out.println("inside DAO register company");

            Company company = new Company(c.getCompanyName());
            company.setCompanyName(c.getCompanyName());
            company.setUsername(c.getUsername());
            company.setPassword(c.getPassword());
            company.setRole("Company");
            getSession().save(company);
            commit();
            return company;

        } catch (HibernateException e) {
            rollback();
            throw new UserException("Exception while creating user: " + e.getMessage());
        }
    }
	
	public JobSeeker registerJobSeeker(JobSeeker j) throws UserException {
        try {
            begin();
            System.out.println("inside DAO register jobSeeker");
            
            JobSeeker jobseeker = new JobSeeker(j.getFirstName(),j.getLastName());
            jobseeker.setFirstName(j.getFirstName());
            jobseeker.setLastName(j.getLastName());
            jobseeker.setEmailID(j.getEmailID());
            jobseeker.setUsername(j.getUsername());
            jobseeker.setPassword(j.getPassword());            
            jobseeker.setRole("JobSeeker");
            getSession().save(jobseeker);
            commit();
            return jobseeker;

        } catch (HibernateException e) {
            rollback();
            throw new UserException("Exception while creating user: " + e.getMessage());
        }
    }
	
	
	//login trying two different get methods for each
	//Company get
	public Company getCompany(String username, String password) throws UserException {
        try {
            begin();
            Query q = getSession().createQuery("from User where username = :username and password = :password");
            q.setString("username", username);
            q.setString("password", password);
            User user = (User) q.uniqueResult();
            if(user!=null){
            String id = String.valueOf(user.getUserID());
            Query q2 = getSession().createQuery("from Company where userID= :id");
            q2.setString("id", id);
            Company company = (Company) q2.uniqueResult();
            commit();
            close();
            return company;
            }
            return null;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not get user " + username, e);
        }
    }
	//Jobsekker
	public JobSeeker getJobSeeker(String username, String password) throws UserException {
        try {
            begin();
            Query q = getSession().createQuery("from User where username = :username and password = :password");
            q.setString("username", username);
            q.setString("password", password);
            User user = (User) q.uniqueResult();
            if(user!=null){
            Long id = user.getUserID();    
        	Query q2 = getSession().createQuery("from JobSeeker where userID= :id");
            q2.setLong("id", id);
            JobSeeker jobseeker = (JobSeeker) q2.uniqueResult();
            commit();
            close();
            return jobseeker;
            }
            return null;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not get user " + username, e);
        }
    }
	// ends ends
	//
	 public Company get(int userId) throws UserException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Company where userID= :userID");
	            q.setInteger("userID", userId);        
	            Company company= (Company) q.uniqueResult();
	            commit();
	            return company;
	        } catch (HibernateException e) {
	            rollback();
	            throw new UserException("Could not get user " + userId, e);
	        }
	    }
	//
	//login
	
	public User get(String username, String password) throws UserException {
        try {
        	System.out.println();
            begin();
            Query q = getSession().createQuery("from User where username = :username and password = :password");
            q.setString("username", username);
            q.setString("password", password);
            User user = (User) q.uniqueResult();
            Long id = user.getUserID();
            Query q2 = getSession().createQuery("from Company where userID= :id");
            q2.setLong("id", id);
            Company company = (Company) q2.uniqueResult();
            if(company==null){
            	Query q3 = getSession().createQuery("from JobSeeker where userID= :id");
                q3.setLong("id", id);
                JobSeeker jobseeker = (JobSeeker) q3.uniqueResult();
                commit();
                close();
                
                return jobseeker;
            }
            commit();
            close();
            return company;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not get user " + username, e);
        }
    }
    
	public User checkUserNameUnique(String username) throws UserException{
		try {
			System.out.println("insde user not null ..1");
            begin();
            System.out.println("insde user not null 1");
            Query q = getSession().createQuery("from User where username = :username");
            q.setString("username", username);
            System.out.println("insde user not null 2");
            User user = (User) q.uniqueResult();
        	System.out.println("insde user not null 3");
        	commit();
        	return user;
		}
		catch(HibernateException e){
			rollback();
            throw new UserException("Could not check uniqure user name" + username, e);
		}
		
	}
	
	//checking is user name password exists while login
	
	public User getUser(String username, String password) throws UserException {
        try {
            begin();
            Query q = getSession().createQuery("from User where username = :username and password = :password");
            q.setString("username", username);
            q.setString("password", password);
            User user = (User) q.uniqueResult();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not get user " + username, e);
        }
    }
	
	
	
	

	
	

}
