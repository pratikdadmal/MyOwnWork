package com.SpringBootDemoProject.dao;

import java.util.List;

import com.SpringBootDemoProject.entity.Employee;

public interface EmployeeDai_infer {

	public boolean saveEmployee(Employee employee);
	public boolean deleteEmployee(int id);
	public String updateEmployee(Employee employee);
	public Employee getProfile(int id);
	public List<Employee> EmployeeList(Employee employee);
	public Employee loginEmployee(Employee employee);

}
