package com.training.UserManagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.UserManagement.beanmodels.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	@Override
	public void saveUser(User user) {
		System.out.println("UserDAOImpl: Attempting to save User");
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}


	@Override
	public void deleteUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(User.class);
        crit.add(Restrictions.eq("id", id));
        User user = (User)crit.uniqueResult();
        session.delete(user);		
	}

	@Override
    @SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(User.class).addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.

		List<User> users = (List<User>) criteria.list();
		
		for (User user : users) {
			System.out.println(user.toString());
		}

        return users;
	}
	
	public boolean checkDuplicateLoginId(String loginId){
		Session session = sessionFactory.getCurrentSession();
		System.out.println("checking for duplicate login Id at Repository level...");
		List<?> result = session.createQuery("from User where loginId=:loginId").setParameter("loginId", loginId).list();
		if(result.size()>0)
			return true;
		else
			return false;
	}
	

}
