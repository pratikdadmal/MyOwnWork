package com.pk.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pk.entity.User;

public class Hibernateconfiguration {
	
	public static SessionFactory getSessionFactory()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(User.class);
		
		SessionFactory sessionfactory =  cfg.buildSessionFactory();
		
		
		return sessionfactory;
		
	}

}
