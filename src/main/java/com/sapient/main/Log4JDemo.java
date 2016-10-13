package com.sapient.main;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4JDemo{

	final static Logger logger = Logger.getLogger(Log4JDemo.class);

	public static void main(String[] args) {
		
		String path  = "log4j.properties";
		
		PropertyConfigurator.configure(path);
		Log4JDemo obj = new Log4JDemo();
		obj.runMe("Logs are here");

	}

	private void runMe(String parameter){

		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}

		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}

		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);

	}

}