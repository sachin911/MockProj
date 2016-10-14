package com.mock.project.service;

import java.util.List;

import com.mock.project.dao.UserDAO;
import com.mock.project.dao.UserDAOImpl;
import com.mock.project.model.User;

public class LoginServiceImpl implements LoginService {
	UserDAO dao = new UserDAOImpl();
	@Override
	public User checkUser(String username, String password) {
		
		List<User> users = dao.findAll(username, password);
		
		if(users.isEmpty() || users == null){
			return null;
		} else {
			return users.get(0);
		}
	}

	public String getType(User u) {
		return u.getUsertype();
	}
	
	@Override
	public void login(User loggedIn) {
		// TODO Auto-generated method stub
		
	}
	
	public int numGet() {
		return 10;
	}

}