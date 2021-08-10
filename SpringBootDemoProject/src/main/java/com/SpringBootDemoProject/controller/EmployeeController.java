package com.SpringBootDemoProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootDemoProject.entity.Employee;
import com.SpringBootDemoProject.services.EmployeeService_Impl;
import com.SpringBootDemoProject.services.Employeeservice_infer;

@RestController
public class EmployeeController {
	
	@Autowired
	//private Employeeservice_infer employeeservice_infer;
	private EmployeeService_Impl employeeService_impl;
	
	@PostMapping(value ="/saveEmployee")
	public boolean saveEmployee(@RequestBody Employee employee)
	{
		boolean b = employeeService_impl.saveEmployee(employee);
		
        return b;		
	}
	
	@DeleteMapping(value="/deleteEmployee")
	public boolean deleteEmployee(@RequestParam int id)
	{	
		boolean b = employeeService_impl.deleteEmployee(id);
		return b;
			
	}

	@PutMapping(value="/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee)
	{
		String str = employeeService_impl.updateEmployee(employee);
		return str;
	}
	
	@GetMapping(value="/getprofileid")
	public Employee getProfileID(@RequestParam int id)
	{
		Employee emp = employeeService_impl.getProfile(id);
		return emp;
	}
	
	@GetMapping(value="/getEmployeeList")
	public List<Employee> getEmployeeList(@RequestBody Employee employee)
	{
		List<Employee> empList = employeeService_impl.EmployeeList(employee);
		
		return empList;
	}
	
	@PostMapping(value="/loginEmployee")
	public Employee loginEmp(@RequestBody Employee employee)
	{
		Employee logEmp = employeeService_impl.loginEmployee(employee);
		return logEmp;
	}
	
	//find user by address
}
