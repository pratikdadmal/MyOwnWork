package com.SpringBootDemoProject.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringBootDemoProject.entity.Employee;

@Repository
public class EmployeeDao_Impl implements EmployeeDai_infer {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveEmployee(Employee employee) {
		
		boolean b = false;
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
		b=true;
		return b;
	}

	@Override
	public boolean deleteEmployee(int id) {
		boolean b = false;
		Session session = sessionFactory.getCurrentSession();
		Employee employee = new Employee();
		employee.setId(id);
		session.delete(employee);
		
		//Employee employee = session.load(Employee.class, id);
		
		b=true;
		return b;
	}

	@Override
	public String updateEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Employee employeeup  = new Employee();
		session.update(employeeup);
		return "Record Updated";
	}

	@Override
	public Employee getProfile(int id) {
	     Session session = sessionFactory.getCurrentSession();
	     Criteria criteria = session.createCriteria(Employee.class);
	     criteria.add(Restrictions.eq("id", id));
	     Employee result = (Employee) criteria.uniqueResult();
	     
		return result;
	}

	@Override
	public List<Employee> EmployeeList(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> empList = criteria.list();
		return empList;
	}

	@Override
	public Employee loginEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eqProperty("username", "username"));
		criteria.add(Restrictions.eqProperty("password", "password"));
		Employee result = (Employee) criteria.uniqueResult();
		return result;
	}
}
