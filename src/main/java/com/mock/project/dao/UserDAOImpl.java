package com.mock.project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.mock.project.model.Order;
import com.mock.project.model.User;

public class UserDAOImpl extends GenericDAOImplementation<User, Long> implements UserDAO {
	
	private EntityManager em;
	
	

	@Override
	public void delete(User entity) {
		// TODO delete a user from db
		
	}

	@Override
	public List<User> findAll(String username, String password) {
		return em.createQuery("from user where username= " + username + " and password= " + password).getResultList(); 
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
