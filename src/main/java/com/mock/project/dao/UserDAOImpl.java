package com.mock.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mock.project.model.Order;
import com.mock.project.model.User;


@Repository
public class UserDAOImpl extends GenericDAOImplementation<User, Long> implements UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	

	@Override
	public void delete(User entity) {
		// TODO delete a user from db
		
	}

	@Override
	public List<User> findAll(String username, String password) {
		System.out.println("USERDAOIMPL:  username:" + username + "  password:  " + password);
				
//		Query query = em.createQuery("from User where username =:uname" +  " and password =:pass");
//		query.setParameter("uname", username);
//		query.setParameter("pass", password);
//		return query.getResultList();
		
		
		Query query = em.createQuery("from User where username =:uname" + " and password =:pass");
		query.setParameter("uname", username);
		query.setParameter("pass", password);
		System.out.println(query.toString());
		
		return query.getResultList();
		
		/*
		if((em.createQuery("SELECT * FROM USERS u WHERE u.username = :username").getResultList()) == null){			
			System.out.println("FOUND NULL IN USERDAOIMPL.findAll()");
			return null;
		} else {
			return em.createQuery("SELECT * FROM USERS WHERE username= " + username + " and password= " + password).getResultList();
		}
		*/
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByPrimaryKey(User id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean findIfUsernameExists(String username) {
		Query query = em.createQuery("from User where username =:uname");
		query.setParameter("uname", username);
		List<User> results = query.getResultList();
		if(results.isEmpty() == true){
			return false;
		} else {
			return true;
		}	
	}

}
