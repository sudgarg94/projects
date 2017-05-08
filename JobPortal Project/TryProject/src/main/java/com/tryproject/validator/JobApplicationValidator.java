package com.tryproject.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tryproject.pojo.JobApplication;

@Component
public class JobApplicationValidator implements Validator{
	
	public boolean supports(Class aClass) {
		return aClass.equals(JobApplication.class);
	}
	
	public void validate(Object obj, Errors errors) {
		JobApplication newJobApplication= (JobApplication) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "photo", "error.invalid.photo", "Resume is required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.emailAddress", "error.invalid.email.emailAddress",
//				"Email Required");
//		if (errors.hasErrors()) {
//            return;//Skip the rest of the validation rules
//        }
		String filename = newJobApplication.getPhoto().getOriginalFilename();
		System.out.println(filename+" filename here");
		if(filename.equals("")){
			errors.rejectValue("photo", "error.invalid.photo", "Resume is required.");
		}
		else if(!filename.endsWith("doc") && !filename.endsWith("pdf")){
			errors.rejectValue("photo", "error.invalid.photo", "Please upload a doc or pdf extension file only.");
		}
		String s =  newJobApplication.getPhoto().getContentType();
		System.out.println("content type of file is "+ s);

	}

}
