package com.mock.project.dao;

import java.util.List;

import com.mock.project.model.Order;
import com.mock.project.model.User;

public interface UserDAO extends GenericDAO<User, Long> {

	List<User> findAll(String username, String password);
	boolean findIfUsernameExists(String username);
}