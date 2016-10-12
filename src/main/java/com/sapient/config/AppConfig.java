package com.sapient.config;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.myapp.spring.mvc")
@EnableTransactionManagement
public class AppConfig {
	
	//this is test comment
	//<bean id="date" class="java.util.Date"></bean>
	@Bean
	public Date date(){
		return new Date();
	}
	
	
	//<bean id="calendar" class="java.util.Calendar" factory-method="getInstance"></bean>
	@Bean
	public Calendar calendar(){
		return Calendar.getInstance();
	}
	
	//persistance.xml <provider>org.hibernate.jpa.HibernatePersistence</provider>
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		
		return new HibernateJpaVendorAdapter();
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@NYsnar1973723.sapient.com:1521:xe");
//		datasource.setUrl("jdbc:oracle:thin:@BLRVIKR27.sapient.com:1521:xe");
		datasource.setUsername("broker");
		datasource.setPassword("broker");
		
		return datasource;
	}
	
	
	private Properties properties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		
		return properties;
	}
	
	//spring implementation of EntityManagerFactory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean factoryBean = 
				new LocalContainerEntityManagerFactoryBean();
		
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(new String[]{"com.myapp.spring.mvc.model"});
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.setJpaProperties(properties());
		
		return factoryBean;
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		
		return txManager;
	}
	
	
}
