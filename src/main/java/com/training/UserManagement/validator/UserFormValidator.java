package com.training.UserManagement.validator;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.training.UserManagement.beanmodels.User;

public class UserFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.user.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.user.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginId", "NotEmpty.user.loginId");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.user.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.user.confirmPassword");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.user.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.user.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.userForm.phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "joinDate", "NotEmpty.userForm.joinDate");

		
		if(user.getFirstName()==null || user.getFirstName()==""){
			errors.rejectValue("firstName", "NotEmpty.user.firstName");
		}
		if(user.getLastName()==null || user.getLastName()==""){
			errors.rejectValue("lastName", "NotEmpty.user.lastName");
		}
		if(user.getLoginId()==null || user.getLoginId()==""){
			errors.rejectValue("loginId", "NotEmpty.user.loginId");
		}
		if(user.getPassword()==null || user.getPassword()==""){
			errors.rejectValue("password", "NotEmpty.user.password");
		}
		// check if the password and confirm password fields match
/*		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
		}*/
		
		if(user.getAddress()==null || user.getAddress()==""){
			errors.rejectValue("address", "NotEmpty.user.address");
		}
		
		if (user.getEmail() == null || user.getEmail()=="") {
			errors.rejectValue("email", "NotEmpty.user.email");
		}

		if (user.getPhone() == null || user.getPhone()=="") {
			errors.rejectValue("phone", "NotEmpty.user.phone");
		}
		
		if(user.getJoinDate() == null || user.getJoinDate().toString()==""){
			errors.rejectValue("joinDate", "NotEmpty.user.joinDate");
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		if(!(sdf.format(user.getJoinDate()).equals(sdf.format(new Date())))){
			errors.rejectValue("joinDate", "Diff.user.joinDate");
		}
		
	}

}
