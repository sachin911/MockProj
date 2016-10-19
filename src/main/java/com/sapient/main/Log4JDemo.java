package com.sapient.main;

import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sapient.model.Block;
import com.sapient.model.Securities;
import com.sapient.service.BrokerService;
import com.sapient.service.SecuritiesService;

import org.hibernate.annotations.common.util.impl.*;

public class Log4JDemo {

	final static Logger logger = Logger.getLogger(Log4JDemo.class);

	public static void main(String[] args) {
		/*
		 * String path = "log4j.properties";
		 * 
		 * PropertyConfigurator.configure(path); Log4JDemo obj = new
		 * Log4JDemo(); obj.runMe("Logs are here");
		 */
		Date current = new Date();
		Block obj = new Block("BUY", "GOOG", 300L, "MARKET", "OPEN", 200.0, 300.0, 100L, current, 120.0);
		Block obj1 = new Block("BUY", "APPL", 300L, "MARKET", "OPEN", 200.0, 300.0, 100L, current, 120.0);
		Block obj2 = new Block("BUY", "MMM", 300L, "MARKET", "OPEN", 200.0, 300.0, 100L, current, 120.0);
		Block obj3 = new Block("BUY", "3M", 300L, "MARKET", "OPEN", 200.0, 300.0, 100L, current, 120.0);
		Securities sec1 = new Securities("APPL", "Apple", 200.2, 20.0, 100, 60, 20.0);
		Securities sec2 = new Securities("GOOG", "google", 200.2, 20.0, 100, 60, 20.0);
		Securities sec3 = new Securities("MMM", "manage", 200.2, 20.0, 100, 60, 20.0);
		Securities sec4 = new Securities("3M", "3M cars", 200.2, 20.0, 100, 60, 20.0);
		System.out.println(obj);
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(
				com.sapient.config.AppConfig.class);
		container.registerShutdownHook();
		BrokerService brokerService = (BrokerService) container.getBean("brokerService");
		brokerService.saveblock(obj);
		brokerService.saveblock(obj1);
		brokerService.saveblock(obj2);
		brokerService.saveblock(obj3);
		SecuritiesService securityService = (SecuritiesService) container.getBean("securitiesService");
		securityService.savesecurities(sec1);
		securityService.savesecurities(sec2);
		securityService.savesecurities(sec3);
		securityService.savesecurities(sec4);
	}

	/*
	 * private void runMe(String parameter){
	 * 
	 * if(logger.isDebugEnabled()){ logger.debug("This is debug : " +
	 * parameter); }
	 * 
	 * if(logger.isInfoEnabled()){ logger.info("This is info : " + parameter); }
	 * 
	 * logger.warn("This is warn : " + parameter);
	 * logger.error("This is error : " + parameter);
	 * logger.fatal("This is fatal : " + parameter);
	 * 
	 * }
	 */
}