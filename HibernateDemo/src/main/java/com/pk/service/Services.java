package com.pk.service;

import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.pk.config.Hibernateconfiguration;
import com.pk.entity.User;

public class Services {

	
	public User preparUser() {
		Scanner scanner = new Scanner(System.in);
		User user = new User();
		System.out.println("Enter the ID");
		user.setId(scanner.nextInt());
		System.out.println("Enter the Name");
		user.setName(scanner.next());
		System.out.println("Enter the Department");
		user.setDepartment(scanner.next());
		System.out.println("Enter the Phone");
		user.setPhone(scanner.next());
		System.out.println("Enter the City");
		user.setCity(scanner.next());
		System.out.println("Enter the Salary");
		user.setSalary(scanner.next());
		
		return user;
	}
	
	public String saveData(User user) {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction =  session.beginTransaction();
		
		User u = preparUser();
		session.save(u);
		
		transaction.commit();
		return "Record Saved";
	}

	public User getUserID(int id) {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session =sessionfactory.openSession();
		User u = session.get(User.class, 2);
		return u;
	}

	public String deleteData(int id1) {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();

		
		User uu = session.load(User.class, id1);
		System.out.println(uu.getId());
		
		session.delete(uu);
		session.beginTransaction().commit();
		return "Deleted";
	}

	public List<User> getAllUser() {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		Criteria criteria =  session.createCriteria(User.class);
		List<User> user = criteria.list();
		return user;
	}

	public String updateUserData(int id2) {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		User u = preparUser();
		session.update(u);
		transaction.commit();
		return "Record Updated";
	}

	public String updateID(int iid) {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		User u = preparUser();
		session.update(u);
		transaction.commit();
		return "ID Updated";
	}

	public String updateName(int upName) {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		User u = preparUser();
		session.update(u);
		session.beginTransaction().commit();
		return "Name Updated";
	}

	public String updateDepartment(int upDepart) {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		User u = preparUser();
		session.update(u);
		session.beginTransaction().commit();
		return "Department Updated";
	}

	public String updatePhone(int upPhone) {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		User u = preparUser();
		session.update(u);
		session.beginTransaction().commit();
		return "Phone Updated";
	}

	public String updateCity(int upCity) {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		User u = preparUser();
		session.update(u);
		session.beginTransaction().commit();
		return "City Updated";
	}

	public String updateSalary(int upSalary) {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		User u = preparUser();
		session.update(u);
		session.beginTransaction().commit();
		return "Salary Updated";
	}

	public List<User> getHighestSalary(String salary) {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		Criteria criteria  = session.createCriteria(User.class);
		criteria.add(Restrictions.gt("salary", salary));
		List<User> list = criteria.list();
		return list;
	}

	public List<User> departSal(String depStr) {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		Criteria criteria  = session.createCriteria(User.class);
		criteria.add(Restrictions.gt("department", depStr));
		List<User> departmentList = criteria.list();
		return departmentList;
	}

	public List<User> getOrderList() {
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.setMaxResults(3);
		criteria.addOrder(Order.asc("name"));
		
		List<User> ascList = criteria.list();
		return ascList;
	}

	
	public List<User> getOrder()
	{
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.setFirstResult(4);
		criteria.addOrder(Order.desc("name"));
		List<User> l = criteria.list();
		return l;
		
	}
	
	public String maxSalary()
	{
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.setProjection(Projections.max("salary"));
		
		List<String> maxsalList = criteria.list();
		
		String i = maxsalList.get(0);
		
		return i;
		
	}

	public double avgSalary()
	{
		SessionFactory sessionfactory = Hibernateconfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.setProjection(Projections.avg("salary"));
		
		List<Double> maxsalList = criteria.list();
		
		double i = maxsalList.get(0);
		
		return i;
		
	}

}
