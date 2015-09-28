package com.training.UserManagement.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.training.UserManagement.beanmodels.LoginBean;
import com.training.UserManagement.beanmodels.User;
import com.training.UserManagement.service.UserService;
//import com.training.UserManagement.validator.UserFormValidator;

@Controller
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	// MessageSource DI to display custom message from messages.properties in case if Login Id provided already exists
	@Autowired
	MessageSource messageSource;
	
	/**
	 * Using a Custom Validator to validate form submission
	 */
/*	@Autowired
	UserFormValidator userFormValidator;*/
	
	/*
	 * used for data binding from web request parameters to JavaBean objects.
	 */
/*	@InitBinder("User")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}*/
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	//Method to handle GET request to login page
	@RequestMapping(value={"/login"}, method=RequestMethod.GET)
	public String displayLoginPage(Model m){
		m.addAttribute("loginBean", new LoginBean());
		return "login";
	}
	
	// Method to handle POST request to Login
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String executeLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginBean") LoginBean loginBean, Model m){
		logger.info("executeLogin():"+loginBean.getUserName()+" trying to login..");
		m.addAttribute("msg", "Login Successful..!");
		return "welcome";
	}
	
	/**
	 *  Method to handle GET request to Add User. Returns to Add User Page.
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/new"}, method=RequestMethod.GET)
	public String registerUser(Model m){
		m.addAttribute("user", new User());
		m.addAttribute("edit", false);
		return "registeruser";
	}
	
	/**
	 * Method to handle POST request to Add User. Returns to success Page.
	 */
	@RequestMapping(value={"/new"}, method=RequestMethod.POST)
	public String saveUser(@Validated User user, BindingResult result, Model m, final RedirectAttributes redirectAttributes){
		logger.info("saveUser(): Attempting to register user..");
        if (result.hasErrors()) {
            return "registeruser";
        }
        if(userService.checkDuplicateLoginId(user.getLoginId())) {
            FieldError userExists =new FieldError("user","loginId", messageSource.getMessage("non.unique.loginId", new String[]{user.getLoginId()}, Locale.getDefault()));
            result.addError(userExists);
            return "registeruser";
        }       
        
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User added successfully!");
		userService.saveUser(user);
		m.addAttribute("user","User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully.");
		return "redirect:/list";
        
	}	
	
	/**
	 *  Method to display list of all users
	 */
	@RequestMapping(value={"/list"}, method=RequestMethod.GET)
	public String findAllUsers(Model m){
		List<User> userList = userService.findAllUsers();
		m.addAttribute("users", userList);
		return "userlist";
	}
	
    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable int id, Model m) {
        User user = userService.findUserById(id);
        m.addAttribute("user", user);
        m.addAttribute("edit", true);
        return "registeruser";
    }
    
    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.POST)
    public String updateUser(@Validated User user, BindingResult result,
            Model model, @PathVariable int id, final RedirectAttributes redirectAttributes) {
 
        if (result.hasErrors()) {
            return "registeruser";
        }
 
        userService.updateUser(user);
 
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
		
        model.addAttribute("user", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
        return "redirect:/list";
    }
	
    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id, final RedirectAttributes redirectAttributes) {
        userService.deleteUserById(id);
        
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
        return "redirect:/list";
    }
}
