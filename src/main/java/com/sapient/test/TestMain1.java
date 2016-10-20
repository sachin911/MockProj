package com.sapient.test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.BaseMatcher.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.sapient.config.AppConfig;
import com.sapient.main.Login;
import com.sapient.model.User;
import com.sapient.service.BrokerService;
import com.sapient.service.SecuritiesService;
import com.sapient.service.UserService;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class TestMain1 {
	@Autowired
	private UserService userservice;
	
	@Autowired
	private BrokerService bs;
	@Autowired
	private SecuritiesService ss;
	@Test
	public void testlogin() {
		User user=new User();
		user.setUser_name("Aadi");
		user.setPassword("Aaditya1@");
		int actual=userservice.authenticateUser(user);
		int expected;
		if(user!=null)
		{
			
			expected=1;
			Assert.assertEquals(actual,(expected));
			
			
		}
		user.setPassword("hello");
		if(user!=null)
		{
			actual=userservice.authenticateUser(user);
			expected=0;
			Assert.assertEquals(actual,(expected));
			
			
		}
		
	}
	
	@Test
	public void testexecution()
	{
		
	}
	
	@Test
	public void securitiestest()
	{
		
	}
	

}
