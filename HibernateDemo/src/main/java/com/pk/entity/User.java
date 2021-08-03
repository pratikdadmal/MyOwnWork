package com.pk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Table")
public class User {
	
	@Id
	@Column(unique=true)
	private int id;
	@Column
	private String  name;
	private String department;
	private String phone;
	private String city;
	private String salary;
	


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id, String name, String department, String phone, String city, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.phone = phone;
		this.city = city;
		this.salary = salary;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getSalary() {
		return salary;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}
	


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", department=" + department + ", phone=" + phone + ", city="
				+ city + ", salary=" + salary + "]";
	}



}
