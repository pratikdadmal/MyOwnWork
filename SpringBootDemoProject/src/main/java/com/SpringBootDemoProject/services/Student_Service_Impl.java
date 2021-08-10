package com.SpringBootDemoProject.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootDemoProject.dao.Student_Dao_Interface;
import com.SpringBootDemoProject.entity.Address;
import com.SpringBootDemoProject.entity.Student;

@Service
@Transactional
public class Student_Service_Impl implements Student_Service_Interface {

	
	@Autowired
	Student_Dao_Interface student_dao_interface;
	
	@Override
	public String saveStudent(Student student) {
		String str = student_dao_interface.saveStudent(student);
		return str;
	}

	@Override
	public List<Student> getStudent(Student student) {
		List<Student> list = student_dao_interface.getStudent(student);
		return list;
	}

	@Override
	public List<Student> getStudentId(int id) {
		List<Student> list = student_dao_interface.getStudentId(id);
		return list;
	}

	@Override
	public String deleteStudent(int id) {
		String str = student_dao_interface.deleteStudent(id);
		return str;
	}

	@Override
	public String updateStudent(Student student, int id) {
		String stud = student_dao_interface.updateStudent(student,id);
		return stud;
	}

	@Override
	public List<Student> findStudentbyCity(String city) {
		System.out.println("checked");
		List<Student> findcity = student_dao_interface.findStudentbyCity(city);
		return findcity;
	}
	
	

}
