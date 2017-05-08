package com.tryproject.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tryproject.dao.UserDAO;
import com.tryproject.exception.UserException;
import com.tryproject.pojo.Job;
import com.tryproject.pojo.JobApplication;
import com.tryproject.pojo.User;

@Component
public class UserValidator implements Validator {
	
	@Autowired
	 @Qualifier("userDao")
	 UserDAO userDao;
	public boolean supports(Class aClass) {
		return aClass.equals(User.class);
	}
	
	public void validate(Object obj, Errors errors) {
		User newUser= (User) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.username", "Username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password is required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.emailAddress", "error.invalid.email.emailAddress",
//				"Email Required");
		if (errors.hasErrors()) {
            return;//Skip the rest of the validation rules
        }
		
		try {
			System.out.println(newUser.getUsername()+ " username");
			System.out.println(newUser.getPassword()+" password");
			User u = userDao.getUser(newUser.getUsername(), newUser.getUsername());
			if(u ==null){
				System.out.println("inside here where user is not found");
				errors.rejectValue("username", "error.invalid.username", "Username and Password doesn't exist.");
			}
		} catch (UserException e) {
			e.printStackTrace();
		}

	}
}
