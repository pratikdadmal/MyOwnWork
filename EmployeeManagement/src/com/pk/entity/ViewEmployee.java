package com.pk.entity;

public class ViewEmployee {
	
	private int id;
	private String username;
	private String password;
	private String email;
	private String role;
	private int active_status;
	private String task;
	private String manager_name;
	
	
	public ViewEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ViewEmployee(int id, String username, String password, String email, String role, int active_status,
			String task, String manager_name) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.active_status = active_status;
		this.task = task;
		this.manager_name = manager_name;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getActive_status() {
		return active_status;
	}


	public void setActive_status(int active_status) {
		this.active_status = active_status;
	}


	public String getTask() {
		return task;
	}


	public void setTask(String task) {
		this.task = task;
	}


	public String getManager_name() {
		return manager_name;
	}


	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}


	@Override
	public String toString() {
		return "ViewEmployee [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", role=" + role + ", active_status=" + active_status + ", task=" + task + ", manager_name="
				+ manager_name + "]";
	}
	
	

}
