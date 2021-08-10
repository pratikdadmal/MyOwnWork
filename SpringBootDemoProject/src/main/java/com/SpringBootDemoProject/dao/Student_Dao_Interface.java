package com.SpringBootDemoProject.dao;

import java.util.List;

import com.SpringBootDemoProject.entity.Address;
import com.SpringBootDemoProject.entity.Student;

public interface Student_Dao_Interface {

	public String saveStudent(Student student);
	public List<Student> getStudent(Student student);
	public List<Student> getStudentId(int id);
	public String deleteStudent(int id);
	public String updateStudent(Student student, int id);
	public List<Student> findStudentbyCity(String city);
}
