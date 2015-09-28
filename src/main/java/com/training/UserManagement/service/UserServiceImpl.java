package com.training.UserManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.UserManagement.beanmodels.User;
import com.training.UserManagement.dao.UserDAO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public User findUserById(int id) {
		return userDAO.findUserById(id);
	}

	public void saveUser(User user) {
		System.out.println("UserServiceImpl: Attempting to save User");
		userDAO.saveUser(user);
		
	}

    /*
     * Since the find method is runs within a Transaction, we can avoid calling update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
	public void updateUser(User user) {
		User userEntity = userDAO.findUserById(user.getId());
        if(userEntity!=null){
        	userEntity.setFirstName(user.getFirstName());
        	userEntity.setLastName(user.getLastName());
        	userEntity.setLoginId(user.getLoginId());
        	userEntity.setPassword(user.getPassword());
        	userEntity.setAddress(user.getAddress());
        	userEntity.setEmail(user.getEmail());
            userEntity.setPhone(user.getPhone());
        	userEntity.setJoinDate(user.getJoinDate());
        }
	}

	public void deleteUserById(int id) {
		userDAO.deleteUserById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userDAO.findAllUsers();
	}

	public boolean checkDuplicateLoginId(String loginId){
		return userDAO.checkDuplicateLoginId(loginId);
	}
}
