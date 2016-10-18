package com.sapient.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


import com.sapient.config.AppConfig;
import com.sapient.dao.GenericDAO;
import com.sapient.dao.GenericDAOImpl;
import com.sapient.model.User;
import com.sapient.service.UserService;


public class Login {
	public static void main(String[] args) {
		 
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

			 
		 ((AbstractApplicationContext) container).registerShutdownHook();
		 UserService userService=  (UserService) container.getBean("UserService");
		/*
		 * EntityManagerFactory
		 * emf=Persistence.createEntityManagerFactory("hibernate");
		 * GenericDAO<User,Long> dao=new
		 * GenericDAOImpl<>(User.class,emf.createEntityManager());
		 */
				int result;
				User user1=new User();
				user1.setUser_name("Aaditya");
				user1.setPassword("aaditya");
				user1.setDeleted('Y');
				user1.setEmail("aadityagupta@gmail.com");
				user1.setFirst_name("Aaditya1");
				user1.setLast_name("Gupta1");
				user1.setSecret_key("hello2");
				user1.setUser_address("110 b1 saden thottam");

		userService.save(user1);
				
				System.out.println("authenticating user");
				User user=new User();
				user.setUser_name("Aadi");
				user.setPassword("aadityagupta1@");
			//	user.setDeleted('Y');
				
				result=userService.authenticateUser(user);
				if(result==1)
				System.out.println("valid user");
				else
					System.out.println("invalid user");
				container.close();
			}
				
public String checkuser(User user)
{
	 System.out.println("Inside check");
	AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

		 
	 ((AbstractApplicationContext) container).registerShutdownHook();
	 UserService userService=  (UserService) container.getBean(UserService.class);
		// EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate");
			//GenericDAO<User,Long> dao=new GenericDAOImpl<>(User.class,emf.createEntityManager());
			int result;
			

		//dao.save(user1);
			List<User> userlist=userService.findAll();
			List<String> username = new ArrayList<String>();
			for (User u : userlist) {
				username.add(u.getUser_name());
			}
			System.out.println("authenticating user");
			
		//	user.setDeleted('Y');
			String vm=null;
			if(username.contains(user.getUser_name()))
			{
			result=userService.authenticateUser(user);
			if(result==1)
			vm="Valid user";
			else
				vm="Invalid credentials";
			}
			else
			{
				vm="Invalid Username";
			}
			container.close();
			return vm;
}
	
	}