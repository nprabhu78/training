package com.training.UserManagement.dao;

import java.util.List;

import com.training.UserManagement.beanmodels.User;

public interface UserDAO {
	User findUserById(int id);
    
    void saveUser(User user);
	     
    void deleteUserById(String userId);
	 
    List<User> findAllUsers();

	boolean checkDuplicateLoginId(String loginId); 

}
