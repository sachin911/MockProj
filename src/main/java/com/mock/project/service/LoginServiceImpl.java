package com.mock.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.dao.UserDAO;
import com.mock.project.dao.UserDAOImpl;
import com.mock.project.model.User;



@Service("Login service")
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserDAO dao = new UserDAOImpl();
	
	
	@Override
	public User checkUser(String username, String password) {
		
		List<User> users = dao.findAll(username, password);
		
		if(users.isEmpty() || users == null){
			System.out.println("User returned is null");
			return null;
		} else {
			User us = users.get(0);
			System.out.println("User returned: " + us.toString());
			return us;
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

	public void addUser(User u) {
		dao.add(u);
	}

}