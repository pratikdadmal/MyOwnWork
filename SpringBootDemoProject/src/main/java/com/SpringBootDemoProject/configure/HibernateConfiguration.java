package com.SpringBootDemoProject.configure;

import java.sql.DriverManager;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.SpringBootDemoProject.entity.Employee;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
	@Value("${db.driver}")
	private String DB_Driver;
	@Value("${db.url}")
	private String DB_Url;
	@Value("${db.username}")
	private String DB_Username;
	@Value("${db.password}")
	private String DB_Password;
	
	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;
	@Value("${hibernate.show_sql}")
	private String HIBERNATE_SHOW_SQL;
	@Value("${hibernate.hbm2ddl.auto}")
	private String HIBERNATE_HBM2DDL_AUTO;
	@Value("${entitymanager.packagesToScan}")
	private String ENTITYMANAGER_PACKAGES_TOSCAN;

	
	@Bean
	public DataSource datasource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(DB_Driver);
		datasource.setUrl(DB_Url);
		datasource.setUsername(DB_Username);
		datasource.setPassword(DB_Password);
		return datasource;
		
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() 
	{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(datasource());
		sessionFactory.setAnnotatedClasses(Employee.class);
		sessionFactory.setPackagesToScan(ENTITYMANAGER_PACKAGES_TOSCAN);
		
		
		Properties hibernateproperties = new Properties();
		hibernateproperties.put("hibernate.dialect", HIBERNATE_DIALECT);
		hibernateproperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		hibernateproperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
		hibernateproperties.put("entitymanager.packagesToScan", ENTITYMANAGER_PACKAGES_TOSCAN);
		sessionFactory.setHibernateProperties(hibernateproperties);
		
		return sessionFactory;
	}

	
	public HibernateTransactionManager transactionManager()
	{
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory().getObject());
		return txManager;
		
	}
 

}
