package com.tryproject.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tryproject.dao.UserDAO;
import com.tryproject.exception.UserException;
import com.tryproject.pojo.Company;
import com.tryproject.pojo.User;

@Component
public class CompanyValidator implements Validator{
	
	 @Autowired
	 @Qualifier("userDao")
	 UserDAO userDao;
	public boolean supports(Class aClass) {
		return aClass.equals(Company.class);
	}

	public void validate(Object obj, Errors errors) {
		Company newCompany = (Company) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "error.invalid.user", "Company Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.emailAddress", "error.invalid.email.emailAddress",
//				"Email Required");
		if (errors.hasErrors()) {
            return;//Skip the rest of the validation rules
        }
		// checking if user exists
		
		try {
			User c = userDao.checkUserNameUnique(newCompany.getUsername());
			if(c !=null){
				errors.rejectValue("username", "error.invalid.company", "Username already Exists. Please choose a different one.");
			}
		} catch (UserException e) {
			System.err.println("Exception in Category Validator");
		}
		//REGEX
		String pattern = "(?=.*[^ ])[a-zA-Z0-9 ]+" ;
        if(!newCompany.getCompanyName().matches(pattern)){
            errors.rejectValue("companyName", "error.invalid.user", "Only Alphanumeric Values Allowed");
            return;
        }
        else if(!newCompany.getUsername().matches(pattern)){
            errors.rejectValue("username", "error.invalid.user", "Only Alphanumeric Values Allowed");
            return;
        }
        else if(!newCompany.getPassword().matches(pattern)){
            errors.rejectValue("password", "error.invalid.password", "Only Alphanumeric Values Allowed");
            return;
        }
        //
	}
}
