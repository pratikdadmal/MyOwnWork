package com.SpringBootDemoProject.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootDemoProject.dao.EmployeeDai_infer;
import com.SpringBootDemoProject.entity.Employee;


@Service
@Transactional
public class EmployeeService_Impl implements Employeeservice_infer {

	
	@Autowired
	private EmployeeDai_infer employeedai_infer;
	
	@Override
	public boolean saveEmployee(Employee employee) {
		boolean b = employeedai_infer.saveEmployee(employee);
		return b;
	}

	@Override
	public boolean deleteEmployee(int id) {
		boolean b = employeedai_infer.deleteEmployee(id);
		return b;
	}

	@Override
	public String updateEmployee(Employee employee) {
		String str = employeedai_infer.updateEmployee(employee);
		return str;
	}

	@Override
	public Employee getProfile(int id) {
		Employee emp = employeedai_infer.getProfile(id);
		return emp;
	}

	@Override
	public List<Employee> EmployeeList(Employee employee) {
		List<Employee> empList = employeedai_infer.EmployeeList(employee);
		return empList;
	}

	@Override
	public Employee loginEmployee(Employee employee) {
		
		Employee logEmp = employeedai_infer.loginEmployee(employee);
		return logEmp;
	}
	

}
