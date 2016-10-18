package com.mock.project.config;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mock.project.jms.SpringIntegrationJms;
import com.mock.project.jms.SpringJmsProducer;

@Configuration
@ComponentScan(basePackages="com.mock.project")
@EnableTransactionManagement
public class AppConfig {
       
       private ConnectionFactory connectionFactory;

	   @Bean
       public Date date(){
              return new Date();
       }
       
       @Bean
       public Calendar calendar(){
              return Calendar.getInstance();
       }
       
       @Bean
       public JpaVendorAdapter jpaVendorAdapter(){
              return new HibernateJpaVendorAdapter();
              
       }

       @Bean
       public DataSource dataSource(){
              DriverManagerDataSource dataSource = new DriverManagerDataSource();
              dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
              dataSource.setUrl("jdbc:oracle:thin:@10.150.222.69:1521:xe");
              dataSource.setUsername("mockproj");
              dataSource.setPassword("sapi123");
              
              return dataSource;
       }
       
       
      /* @Bean
       public ActiveMQConnectionFactory activeMQConnectionFactory(){
    	   ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
    	   activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
    	   return activeMQConnectionFactory;
       }
       
       @Bean
       public CachingConnectionFactory cachingConnectionFactory(){
    	   CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
    	   cachingConnectionFactory.setTargetConnectionFactory(activeMQConnectionFactory());
    	   cachingConnectionFactory.setSessionCacheSize(10);
    	   cachingConnectionFactory.setCacheConsumers(false);
    	   return cachingConnectionFactory;
       }
       
       @Bean
       public JmsTemplate jmsTemplate(){
    	   JmsTemplate jmsTemplate = new JmsTemplate();
    	   jmsTemplate.setConnectionFactory(connectionFactory);
    	   return jmsTemplate;
       }
       
       @Bean
       public MarshallAndSend marshallAndSend(){
    	   MarshallAndSend marshallAndSend = new MarshallAndSend();
    	   marshallAndSend.setJmsTemplate(jmsTemplate());
    	   return marshallAndSend;
       }
       
       @Bean
       public UnmarshallAndSave unmarshallAndSave(){
    	   UnmarshallAndSave unmarshallAndSave = new UnmarshallAndSave();
    	   unmarshallAndSave.setJmsTemplate(jmsTemplate());
    	   return unmarshallAndSave;
       }*/
      
       /* 
       @Bean
       public SpringIntegrationJms springIntExample(){
    	   SpringIntegrationJms springIntExample = new SpringIntegrationJms();
    	   springIntExample.setJmsTemplate(jmsTemplate());
    	   return springIntExample;  	   
       }
       
       @Bean 
       public ActiveMQQueue messageDestination(){
    	   ActiveMQQueue messageDestination = new ActiveMQQueue("messageQueue1");
    	   return messageDestination;
       }
       
       @Bean
       public SpringJmsProducer springJmsProducer(){
    	   Destination destination = null;
    	   JmsTemplate template = null;  	   
    	   SpringJmsProducer springJmsProducer = new SpringJmsProducer(destination,template);
    	   return springJmsProducer;
       }*/
       
       
       
       private Properties properties(){
              Properties properties = new Properties();
              properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
              properties.put("hibernate.hbm2ddl.auto", "update");
              properties.put("hibernate.show_sql", "true");
              return properties;
       }
       
       @Bean
       public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
          LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
          factoryBean.setDataSource(dataSource());
          factoryBean.setPackagesToScan(new String[]{"com.mock.project.model"});
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


