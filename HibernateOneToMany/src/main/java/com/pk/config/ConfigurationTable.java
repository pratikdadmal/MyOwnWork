package com.pk.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pk.entity.Answer;
import com.pk.entity.Question;

public class ConfigurationTable {
	
	public static SessionFactory getSessionFactory()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
	}

}
