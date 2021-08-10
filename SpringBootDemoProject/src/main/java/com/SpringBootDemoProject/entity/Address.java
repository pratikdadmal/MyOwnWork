package com.SpringBootDemoProject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stu_address")
public class Address {
	
	@Id
	private int id;
	private String city;
	private String dist;
    private int pincode;
    
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int id, String city, String dist, int pincode) {
		super();
		this.id = id;
		this.city = city;
		this.dist = dist;
		this.pincode = pincode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", dist=" + dist + ", pincode=" + pincode + "]";
	}
    
    
    

}
