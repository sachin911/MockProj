package com.sapient.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LoggerConfig {
	final static Logger logger = Logger.getLogger(LoggerConfig.class);
	
	public Logger getLogConfig(){
		
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("log4j.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PropertyConfigurator.configure(props);
//		String path  = "log4j.properties";
//		
//		PropertyConfigurator.configure(path);
//		
		return logger;
		
	}
	
	
	public static void main(String[] args) {
		LoggerConfig logConfig = new LoggerConfig();
		Logger log = logConfig.getLogConfig();
		
		log.warn("This is warn : " );
		log.error("This is error : ");
		log.fatal("This is fatal : ");
		log.info("what??");
	}
}
