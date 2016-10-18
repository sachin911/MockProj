package com.sapient.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sapient.model.User;

@Repository
@Component("UserDAO")
// @Transactional(propagation=Propagation.REQUIRED)
public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {

	@Override
	public int authenticateUser(User entity) {
		System.out.println("inside authenticate user");
		System.out.println("generic dao impl");

		User temp = (User) entity;
		System.out.println(temp.getUser_name());
		System.out.println(temp.getDeleted());
		String password = null;
		Boolean deleted = null;
		Query query = em.createQuery("from User where user_name=:uname");

		query.setParameter("uname", temp.getUser_name());
		User e = (User) query.getSingleResult();

		System.out.println(e.getDeleted());
		System.out.println(e.getPassword());

		if (query.getMaxResults() == 0)
			return 0;
		else {

			if (temp.getPassword().equals(e.getPassword()))
				return 1;
			else
				return 0;
		}

	}

	@Override
	public List<User> findAll() {
		
		return em.createQuery("from User").getResultList();
	}

}