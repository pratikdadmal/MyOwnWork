package com.SpringBootDemoProject.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootDemoProject.dao.EmployeeDai_infer;
import com.SpringBootDemoProject.dao.EmployeeDao_Impl;
import com.SpringBootDemoProject.entity.Employee;


@Service
@Transactional
public class EmployeeService_Impl implements Employeeservice_infer {

	
	@Autowired
	//private EmployeeDai_infer employeedai_infer;
	
	private EmployeeDao_Impl employeeDao_impl;
	
	@Override
	public boolean saveEmployee(Employee employee) {
		boolean b = employeeDao_impl.saveEmployee(employee);
		return b;
	}

	@Override
	public boolean deleteEmployee(int id) {
		boolean b = employeeDao_impl.deleteEmployee(id);
		return b;
	}

	@Override
	public String updateEmployee(Employee employee) {
		String str = employeeDao_impl.updateEmployee(employee);
		return str;
	}

	@Override
	public Employee getProfile(int id) {
		Employee emp = employeeDao_impl.getProfile(id);
		return emp;
	}

	@Override
	public List<Employee> EmployeeList(Employee employee) {
		List<Employee> empList = employeeDao_impl.EmployeeList(employee);
		return empList;
	}

	@Override
	public Employee loginEmployee(Employee employee) {
		
		Employee logEmp = employeeDao_impl.loginEmployee(employee);
		return logEmp;
	}
	

}
