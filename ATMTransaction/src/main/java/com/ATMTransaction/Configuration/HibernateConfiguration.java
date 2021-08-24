package com.ATMTransaction.Configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ATMTransaction.Entity.User1ATM;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
	@Value("${data.driver}")
	private String DATA_Driver;
	@Value("${data.url}")
	private String DATA_URL;
	@Value("${data.username}")
	private String DATA_USERNAME;	
	@Value("${data.password}")
	private String DATA_PASSWORD;
	
	
	@Value("${hibernate.dialect}")
    private String HIBERNATE_DIALECT;
	@Value("${hibernate.show_sql}")
	private String HIBERNATE_SHOW_SQL;
	@Value("${hibernate.hbm2ddl.auto}")
	private String HIBERNATE_HBM2DDL_AUTO;
	@Value("${entitymanager.packagesToScan}")
	private String ENTITYMANAGER_PACKAGE_TOSCAN;
	
	
	
	@Bean
	public DataSource datasource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(DATA_Driver);
		datasource.setUrl(DATA_URL);
		datasource.setUsername(DATA_USERNAME);
		datasource.setPassword(DATA_PASSWORD);
		
		return datasource;
	}
	
	//When will get this ERROR then == Spring-boot: required a bean named 'entityManagerFactory' that could not be found
	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(datasource());
		sessionFactory.setAnnotatedClasses(User1ATM.class);
		sessionFactory.setPackagesToScan(ENTITYMANAGER_PACKAGE_TOSCAN);
		
		Properties hp = new Properties();
		hp.put("hibernate.dialect", HIBERNATE_DIALECT);
		hp.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		hp.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
		hp.put("entitymanager.packagesToScan", ENTITYMANAGER_PACKAGE_TOSCAN);
		
		sessionFactory.setHibernateProperties(hp);
		return sessionFactory;
		
	}
	
	public HibernateTransactionManager transactionManager()
	{
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory().getObject());
		return txManager;
		
	}

}
