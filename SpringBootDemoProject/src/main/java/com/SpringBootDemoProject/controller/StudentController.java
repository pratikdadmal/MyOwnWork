package com.SpringBootDemoProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootDemoProject.entity.Student;
import com.SpringBootDemoProject.services.Student_Service_Interface;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	Student_Service_Interface student_service_interface;
	
	@PostMapping(value="/saveStudent")
	public String saveStudent(@RequestBody Student student)
	{
		String str =  student_service_interface.saveStudent(student);
		return str;
		
	}
	
	@GetMapping(value="/getStudent")
	public List<Student> getStudent(@RequestBody Student student)
	{
		List<Student> list =  student_service_interface.getStudent(student);
		return list;
		
	}
	
	@GetMapping(value="/getparticular")
	public List<Student> getStudent(@RequestParam int id)
	{
		List<Student> list =  student_service_interface.getStudentId(id);
		return list;
		
	}
	
	@DeleteMapping(value="/deletestudent")
	public String deleteStudent(@RequestParam int id)
	{
		String str = student_service_interface.deleteStudent(id);
		return str;
		
	}
	
	
	@PutMapping(value="/updatestudent")
	public String updateStudent(@RequestBody Student student, int id)
	{
		String stud = student_service_interface.updateStudent(student,id);
		return stud;
		
	}
}
