package com.SpringBootDemoProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_ojt")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private double salary;
	@Column
	private String department;
	@Column
	private String profile;
	@Column
	private int activestatus;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int id, String username, String password, double salary, String department, String profile,
			int activestatus) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.salary = salary;
		this.department = department;
		this.profile = profile;
		this.activestatus = activestatus;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public int getActivestatus() {
		return activestatus;
	}


	public void setActivestatus(int activestatus) {
		this.activestatus = activestatus;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", salary=" + salary
				+ ", department=" + department + ", profile=" + profile + ", activestatus=" + activestatus + "]";
	}
	
	

}
