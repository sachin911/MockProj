package com.sapient.config;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LoggerConfig {
	final static Logger logger = Logger.getLogger(LoggerConfig.class);
	
	public Logger getLogConfig(){
		String path  = "log4j.properties";
		
		PropertyConfigurator.configure(path);
		
		return logger;
		
	}
}
