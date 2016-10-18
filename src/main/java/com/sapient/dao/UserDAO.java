package com.sapient.dao;

import java.io.Serializable;
import java.util.List;

import com.sapient.model.User;

public interface UserDAO extends GenericDAO<User,Long>{

	 int authenticateUser(User entity); 
	 List<User> findAll();
	void changepass(User user);

}
