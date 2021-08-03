package com.pk.Main;

import java.util.ArrayList;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pk.config.ConfigurationTable;
import com.pk.entity.Answer;
import com.pk.entity.Question;

public class MCQTest {
	public static void main(String[] args){
		
		SessionFactory sessionFactory =  ConfigurationTable.getSessionFactory();
		Session session = sessionFactory.openSession();
		
	    Transaction tr = session.beginTransaction();
	    
	    Answer ans1 = new Answer();
	    ans1.setAnswername("Java is a programming language");
	    ans1.setPostedBy("ravi malik");
	    
	    Answer ans2 = new Answer();
	    ans1.setAnswername("Java is Platform");
	    ans1.setPostedBy("sudhir Kumar");
	   
	    Answer ans3 = new Answer();
	    ans3.setAnswername("Servlet is an interface");
	    ans3.setPostedBy("jai Kumar");
	    
	    Answer ans4 = new Answer();
	    ans4.setAnswername("Servlet is a API");
	    ans4.setPostedBy("arun");
	    
	    ArrayList<Answer> ansList1 = new ArrayList<Answer>();
	    ansList1.add(ans1);
	    ansList1.add(ans2);
	    
	    ArrayList<Answer> ansList2 = new ArrayList<Answer>();
	    ansList2.add(ans3);
	    ansList2.add(ans4);
	    
	    Question question1 = new Question();
	    question1.setQname("What is Java");
	    question1.setAnswer(ansList1);
	    
	    
	    Question question2 = new Question();
	    question2.setQname("What is Servlet");
	    question2.setAnswer(ansList2);
	    
	    session.persist(question1);
	    session.persist(question2);
	    
	    tr.commit();
	    session.close();
		
		 System.out.println("success");    
	}

}
