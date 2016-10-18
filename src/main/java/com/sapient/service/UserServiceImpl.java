package com.sapient.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.dao.UserDAO;
import com.sapient.model.User;
import com.sapient.service.UserService;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */

	// @PostConstruct
	// public void initialize()//life cycle methods which are called implicitly
	// {
	// System.out.println("inside init");
	// }
	//

	/*
	 * @Override public void saveUser(User order) { dao.save(order); }
	 * 
	 * @Override public void delete(User order) { dao.delete(order);
	 * 
	 * }
	 */
	@PreDestroy
	public void destroy()// life cycle methods which are called implicitly
	{
		System.out.println("inside destroy");
	}

	public static void main(String[] args) {

	}

	@Override
	public int authenticateUser(User user) {

		System.out.println("inside orderservice");
		return dao.authenticateUser(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void changePass(User user) {
		// TODO Auto-generated method stub
		dao.changepass(user);
	}

	public void save(User user1) {
		// TODO Auto-generated method stub
		dao.save(user1);
	}

	/*
	 * @Service("UserService")
	 * 
	 * @Transactional public class UserServiceImpl implements UserService {
	 * 
	 * @Autowired private UserDAO dao;
	 * 
	 * public void setDao(UserDAO dao) { this.dao = dao; }
	 * 
	 * @Override public boolean authenticateUser(User user) {
	 * System.out.println("inside user service impl"); return
	 * dao.authenticateUser(user); }
	 * 
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 * 
	 * 
	 * public List<User> findAllUsers() { return dao.findAll(); }
	 * 
	 */
}