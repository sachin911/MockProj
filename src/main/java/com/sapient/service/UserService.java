package com.sapient.service;

import java.util.List;

import com.sapient.model.User;

public interface UserService {
	int authenticateUser(User user);
	List<User> findAll();
	void save(User user1);
	
}
