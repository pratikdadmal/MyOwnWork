package com.SpringBootDemoProject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringBootDemoProject.entity.Student;

@Repository
public class Student_Dao_Impl implements Student_Dao_Interface{

	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public String saveStudent(Student student) {
		Session session = sessionfactory.getCurrentSession();
		session.save(student);
		return "Student Saved";
	}

	@Override
	public List<Student> getStudent(Student student) {
		Session session = sessionfactory.getCurrentSession();
		Criteria criteria  = session.createCriteria(Student.class);
		List<Student> list = criteria.list();
		return list;
	}

	@Override
	public List<Student> getStudentId(int id) {
		Session session = sessionfactory.getCurrentSession();
		Criteria criteria  = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("id", id));
		List<Student> list = (List<Student>) criteria.uniqueResult();
		return list;
	}

	@Override
	public String deleteStudent(int id) {
		Session session = sessionfactory.getCurrentSession();
		Student student1 = session.load(Student.class, id);
		session.delete(student1);
		return "Deleted";
	}

	@Override
	public String updateStudent(Student student, int id) {
		Session session = sessionfactory.getCurrentSession();
		Student stud = new Student();
		stud.setId(id);
	    session.update(stud); 
		return "Updated";
	}

	
}
