package com.mock.project.dao;

import java.util.List;

import com.mock.project.model.User;

public interface UserDAO extends GenericDAO<User> {

	List<User> findAll(String username, String password);

}