package com.tryproject.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tryproject.dao.UserDAO;
import com.tryproject.exception.UserException;
import com.tryproject.pojo.JobSeeker;
import com.tryproject.pojo.User;

@Component
public class JobSeekerValidator implements Validator{
	
//	 @Autowired
//	 @Qualifier("userDao")
//	 UserDAO userDao;
	UserDAO userDao = new UserDAO();
	public boolean supports(Class aClass) {
		return aClass.equals(JobSeeker.class);
	}

	public void validate(Object obj, Errors errors) {
		JobSeeker jobseeker = (JobSeeker) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.firstName", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.lastName", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.username", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
//		
		if (errors.hasErrors()) {
            return;//Skip the rest of the validation rules
        }
		// check if user exists
		try {
			User c = userDao.checkUserNameUnique(jobseeker.getUsername());
			if(c !=null)
				errors.rejectValue("username", "error.invalid.username", "Username already Exists. Please choose a different one.");
			
		} catch (UserException e) {
			System.err.println("Exception in JobSeeker Validator");
		}
		
		//REGEX
		String pattern = "(?=.*[^ ])[a-zA-Z0-9 ]+" ;
        if(!jobseeker.getFirstName().matches(pattern)){
            errors.rejectValue("firstName", "error.invalid.firstName", "Only Alphanumeric Values Allowed");
            return;
        }
        else if(!jobseeker.getLastName().matches(pattern)){
            errors.rejectValue("lastName", "error.invalid.lastName", "Only Alphanumeric Values Allowed");
            return;
        }
        else if(!jobseeker.getUsername().matches(pattern)){
            errors.rejectValue("username", "error.invalid.username", "Only Alphanumeric Values Allowed");
            return;
        }
        else if(!jobseeker.getPassword().matches(pattern)){
            errors.rejectValue("password", "error.invalid.password", "Only Alphanumeric Values Allowed");
            return;
        }
        
        //EMAIL
        String emailpattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(!jobseeker.getEmailID().matches(emailpattern)){
            errors.rejectValue("emailID", "error.invalid.emailID", "Invalid Email ID");
            return;
        }
        //
		
	}

}
