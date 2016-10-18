package com.sapient.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Checksum;

import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sapient.config.AppConfig;
import com.sapient.dao.GenericDAO;
import com.sapient.dao.GenericDAOImpl;
import com.sapient.model.Block;
import com.sapient.model.User;
import com.sapient.service.UserService;

public class Login {
	public static void main(String[] args) {

		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

		((AbstractApplicationContext) container).registerShutdownHook();
		UserService dao = (UserService) container.getBean("UserService");

		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("hibernate");
		// GenericDAO<User, Long> dao = new GenericDAOImpl<>(User.class,
		// emf.createEntityManager());

		// com.sapient.dao.GenericDAO<User, Long> dao = new
		// com.sapient.dao.GenericDAOImpl<>(User.class,
		// Persistence.createEntityManagerFactory("hibernate").createEntityManager());

		int result;
		User user1 = new User();
		user1.setUser_name("Aaditya");
		user1.setPassword("aaditya");
		user1.setDeleted('Y');
		user1.setEmail("aadityagupta@gmail.com");
		user1.setFirst_name("Aaditya1");
		user1.setLast_name("Gupta1");
		user1.setSecret_key("hello2");
		user1.setUser_address("110 b1 saden thottam");

		// dao.save(user1);

		System.out.println("authenticating user");
		User user = new User();
		user.setUser_name("Aaditya");
		user.setPassword("aaditya");
		Login l = new Login();
		System.out.println(l.checkuser(user));
		// user.setDeleted('Y');

		// result=authenticateUser(user);
		// if(result==1)
		// System.out.println("valid user");
		// else
		// System.out.println("invalid user");
		// container.close();
	}

	public String checkuser(User user) {
		System.out.println("Inside check");
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

		((AbstractApplicationContext) container).registerShutdownHook();
		UserService userService = (UserService) container.getBean("UserService");
		// EntityManagerFactory
		// emf=Persistence.createEntityManagerFactory("hibernate");
		// GenericDAO<User,Long> dao=new
		// GenericDAOImpl<>(User.class,emf.createEntityManager());
		int result;

		// dao.save(user1);
		List<User> userlist = userService.findAll();
		List<String> username = new ArrayList<String>();
		for (User u : userlist) {
			username.add(u.getUser_name());
		}
		System.out.println("authenticating user");

		// user.setDeleted('Y');
		String vm = null;
		if (username.contains(user.getUser_name())) {
			result = userService.authenticateUser(user);
			if (result == 1)
				vm = "Valid user";
			else
				vm = "Invalid credentials";
		} else {
			vm = "Invalid Username";
		}
		container.close();
		return vm;
	}



public void updatepass(User user) {
	// TODO Auto-generated method stub
	AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

	 
	 ((AbstractApplicationContext) container).registerShutdownHook();
	 UserService userService=  (UserService) container.getBean(UserService.class);
		List<User> userlist=userService.findAll();
		
		Map<String,String> userkey=new HashMap<>();
		for (User user2 : userlist) {
			userkey.put(user2.getUser_name(),user2.getSecret_key());
		}
	if(userkey.keySet().contains(user.getUser_name()))
			{
		if(userkey.get(user.getUser_name()).equals(user.getSecret_key()))
{
	userService.changePass(user);
}
			}
		
}

}
