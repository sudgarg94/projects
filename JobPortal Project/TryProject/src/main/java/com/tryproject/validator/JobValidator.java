package com.tryproject.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.tryproject.pojo.Job;

@Component
public class JobValidator implements Validator{
	
	
	public boolean supports(Class aClass) {
		return aClass.equals(Job.class);
	}
	
	public void validate(Object obj, Errors errors) {
		Job newJob= (Job) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.title", "Title is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "error.invalid.message", "Job Description is required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.emailAddress", "error.invalid.email.emailAddress",
//				"Email Required");
		if (errors.hasErrors()) {
            return;//Skip the rest of the validation rules
        }
		//REGEX
		String pattern = "(?=.*[^ ])[a-zA-Z0-9 ]+" ;
        if(!newJob.getTitle().matches(pattern)){
            errors.rejectValue("title", "error.invalid.title", "Only Alphanumeric Values Allowed");
            return;
        }
        else if(!newJob.getMessage().matches(pattern)){
            errors.rejectValue("message", "error.invalid.message", "Only Alphanumeric Values Allowed");
            return;
        }
    	//

	}

	
	
	
	
	

}
