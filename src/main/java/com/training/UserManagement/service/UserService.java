package com.training.UserManagement.service;

import java.util.List;

import com.training.UserManagement.beanmodels.User;

public interface UserService {
	 
	User findUserById(int id);
	     
    void saveUser(User user);
	     
    void updateUser(User user);
	     
    void deleteUserById(String id);
	 
    List<User> findAllUsers();

	boolean checkDuplicateLoginId(String loginId); 


}
