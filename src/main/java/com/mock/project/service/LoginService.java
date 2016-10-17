package com.mock.project.service;
import com.mock.project.model.Order;
import com.mock.project.model.User;


public interface LoginService {	
	User checkUser(String username, String password);	
	void login(User loggedIn);
	public String getType(User u);
	public int numGet();
	public void addUser(User u);
}