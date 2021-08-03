package com.SpringBootDemoProject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_table")
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	private String name;
	private String gender;
	private String std_class;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String gender, String std_class, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.std_class = std_class;
		this.address = address;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStd_class() {
		return std_class;
	}

	public void setStd_class(String std_class) {
		this.std_class = std_class;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", std_class=" + std_class + ", address="
				+ address + "]";
	}
 	

	
	
}
