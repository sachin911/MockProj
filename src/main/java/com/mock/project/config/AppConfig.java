package com.mock.project.config;

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
@ComponentScan(basePackages="com.mock.project")
@EnableTransactionManagement
public class AppConfig {
       
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


