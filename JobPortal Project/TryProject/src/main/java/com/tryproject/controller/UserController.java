package com.tryproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tryproject.exception.UserException;
import com.tryproject.pojo.Company;
import com.tryproject.pojo.JobSeeker;
import com.tryproject.pojo.User;
import com.tryproject.dao.UserDAO;
import com.tryproject.validator.CompanyValidator;
import com.tryproject.validator.JobSeekerValidator;
import com.tryproject.validator.UserValidator;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	 @Autowired
	 @Qualifier("userDao")
	 UserDAO userDao;
	 
	 @Autowired
	 @Qualifier("userValidator")
	 UserValidator uvalidator;
	 
	 @Autowired
	 @Qualifier("companyValidator")
	 CompanyValidator cvalidator;
	 
	 @Autowired
	 @Qualifier("jobseekerValidator")
	 JobSeekerValidator jvalidator;
	 
	 @InitBinder("company")
	 private void initCompanyBinder(WebDataBinder binder) {
       binder.setValidator(cvalidator);
	 }
	 
	 @InitBinder("/user/registerJobSeeker")
	 private void initJobSeekerBinder(WebDataBinder binder) {
       binder.setValidator(jvalidator);
	 }
	 
	 @InitBinder("user/login")
	 private void initUserBinder(WebDataBinder binder) {
       binder.setValidator(uvalidator);
	 }
	 
	 @RequestMapping(value = "/user/registerCompany", method = RequestMethod.GET)
	    protected ModelAndView registerCompany() throws Exception {
		 
	        return new ModelAndView("register-company", "company", new Company());
	    }
	 
	 @RequestMapping(value = "/user/registerCompany", method = RequestMethod.POST)
	    protected ModelAndView registerNewCompany(HttpServletRequest request,  @ModelAttribute("company") Company company, BindingResult result) throws Exception {
		 	
	       	cvalidator.validate(company, result);

	        if (result.hasErrors()) {
	            return new ModelAndView("register-company", "company", company);
	        }

	        try {
	            Company c = userDao.registerCompany(company);
	            request.getSession().setAttribute("user", c);
	            return new ModelAndView("user-home", "user", c);

	        } catch (UserException e) {
	            System.out.println("Exception: " + e.getMessage());
	            return new ModelAndView("error", "errorMessage", "error while login");
	        }
	    }

	 
	 //register Job Seeker
	 
	 @RequestMapping(value = "/user/registerJobSeeker", method = RequestMethod.GET)
	    protected ModelAndView registerJobSeeker() throws Exception {
	        System.out.print("registerJobseeker");

	        return new ModelAndView("register-jobseeker", "jobseeker", new JobSeeker());

	    }
	 
	 @RequestMapping(value = "/user/registerJobSeeker", method = RequestMethod.POST)
	    protected ModelAndView registerJobSeeker(HttpServletRequest request,  @ModelAttribute("jobseeker") JobSeeker jobseeker, BindingResult result) throws Exception {

	       	jvalidator.validate(jobseeker, result);

	        if (result.hasErrors()) {
	            return new ModelAndView("register-jobseeker", "jobseeker", jobseeker);
	        }

	        try {

	            System.out.print("registerJobseeker here");
	            JobSeeker j = userDao.registerJobSeeker(jobseeker);
	            request.getSession().setAttribute("user", j);
	            
	            return new ModelAndView("user-home", "user", j);

	        } catch (UserException e) {
	            System.out.println("Exception: " + e.getMessage());
	            return new ModelAndView("error", "errorMessage", "error while login");
	        }
	    }
	 
	 
	 //login
	 
	 @RequestMapping(value = "/user/login", method = RequestMethod.GET)
	    protected ModelAndView goToUserHome(HttpServletRequest request) throws Exception {
		 	//HttpSession session = (HttpSession) request.getSession();
		 	return new ModelAndView("login", "user", new User());
	        
	    }
	 
	 @RequestMapping(value = "/user/login", method = RequestMethod.POST)
	    protected ModelAndView loginUser(HttpServletRequest request,@ModelAttribute("user") User user, BindingResult result) throws Exception{
		 	
		 	uvalidator.validate(user, result);

	        if (result.hasErrors()) {
	        	System.out.println("inside result error");
	        	return new ModelAndView("login", "user", user);
	            //return "login";
	        }

		 	
	        HttpSession session = (HttpSession) request.getSession();
	        try {
	            System.out.print("loginUser");
	            //User c = userDao.get(request.getParameter("username"), request.getParameter("password"));
	            Company c = userDao.getCompany(user.getUsername(), user.getPassword());
	            
	            JobSeeker j = userDao.getJobSeeker(user.getUsername(), user.getPassword());
	            
	            if(c!=null){
		            session.setAttribute("user", c);
		            return new ModelAndView("user-home", "user", c);
		            //return "user-home";
		            }
	            
	            if(j!=null)
	            {
	            	session.setAttribute("user", j);
	            	return new ModelAndView("user-home", "user", j);
	            	//return "user-home";
	            }	 
	            
	            
                System.out.println("UserName/Password does not exist");
                session.setAttribute("errorMessage", "UserName/Password does not exist");
                return new ModelAndView("error", "errorMessage", "error while login");
                //return "error";
            
	                       
	            
	            

	        } catch (UserException e) {
	            System.out.println("Exception: " + e.getMessage());
	            session.setAttribute("errorMessage", "error while login");
	            return new ModelAndView("error", "errorMessage", "error while login");
	        }

	    }
	 
	 //logout
	 
	 @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	    public String logout(HttpServletRequest request){
		 request.getSession().invalidate();
		 return "redirect: /main";
	        
	    }
	 
	 //home
	 @RequestMapping(value = "/user/home", method = RequestMethod.GET)
	    public String home(HttpServletRequest request){
		 return "user-home";
	        
	    }
	 
	 
	 


	 
	 

}
