package com.pk.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pk.configuration.JdbcConnection;
import com.pk.model.User;

public class Operation {

	public String saveData(User user)
	{    
		 String msg = null;
		
		try {
			
		    Scanner sc = new Scanner(System.in);
			
			Connection con = JdbcConnection.getConnection();
			
			PreparedStatement pstm = con.prepareStatement("insert into oldemp_dataojt(id,name,department,phone,city,salary) values(?,?,?,?,?,?)");
	     
			System.out.println("Enter the ID");
			pstm.setInt(1, sc.nextInt());
			System.out.println("Enter the Name");
			pstm.setString(2, sc.next());
			System.out.println("Enter the Department");
			pstm.setString(3, sc.next());
			System.out.println("Enter the Phone");
			pstm.setString(4, sc.next());
			System.out.println("Enter the City");
			pstm.setString(5, sc.next());
			System.out.println("Enter the Salary");
			pstm.setString(6, sc.next());
			
//			pstm.setInt(1, user.getId());
//			pstm.setString(2, user.getName());
//			pstm.setString(3, user.getDepartment());
//			pstm.setString(4, user.getPhone());
//			pstm.setString(5, user.getCity());

			int result = pstm.executeUpdate();
			if(result>0)
			{
				msg="Data Inserted";
			}
			else
			{
				msg="Not Inserted";
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return msg;
		
	}
	
	
	public User getUserID(int id)
	{
		User user = new User();
		try {
			Connection con = JdbcConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select * from oldemp_dataojt where id=?");
			pstm.setInt(1, id);
			
			ResultSet resultSet = pstm.executeQuery();
			if(resultSet.next())
			{
			user.setId(resultSet.getInt("id"));
			user.setName(resultSet.getString("name"));
			user.setDepartment(resultSet.getString("department"));
			user.setPhone(resultSet.getString("phone"));
			user.setCity(resultSet.getString("city"));
			user.setCity(resultSet.getString("salary"));
			}
			else
			{
				System.out.println("Id not present");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return user;
		
	}
	
	//Delete Record and Show All Record List
	public String deleteData(int id1)
	{
		String msg1 = null;
		Connection con=null;
		try {
			con = JdbcConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("delete from oldemp_dataojt where id=?");
			
			pstm.setInt(1, id1);

			int result = pstm.executeUpdate();
			if(result!=0)
			{
				msg1="Data Deleted";
			}
			else
			{
				msg1="Not Deleted";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return msg1;
     
	}


	public List<User> getAllUser() {
	  
		List<User> list = new ArrayList<>();
	  
		Connection con;
		String sql="select * from oldemp_dataojt";
		try {
			con = JdbcConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			
			ResultSet resultSet= pstm.executeQuery();
			while(resultSet.next())
			{
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setDepartment(resultSet.getString(3));
				user.setPhone(resultSet.getString(4));
				user.setCity(resultSet.getString(5));
				user.setSalary(resultSet.getString(6));
				
				list.add(user);
			}
			
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return list;
	}


	public String updateUserData(int id2) {
		
		String msg=null;
		String sql="update oldemp_dataojt set name=?,department=?,phone=?,city=?,salary=? where id=?";
		
		try {
			 Scanner sc = new Scanner(System.in);
			Connection con = JdbcConnection.getConnection();
            PreparedStatement  pstm = con.prepareStatement(sql);
            
            System.out.println("Enter the Name");
            pstm.setString(1, sc.next());
            System.out.println("Enter the Department");
            pstm.setString(2, sc.next());
            System.out.println("Enter the Phone");
            pstm.setString(3,sc.next());
            System.out.println("Enter the City");
            pstm.setString(4, sc.next());
            System.out.println("Enter the Salary");
            pstm.setString(5, sc.next());
            pstm.setInt(5, id2);
            int result = pstm.executeUpdate();
            
            if(result>0)
            {
            	msg="User Record Updated";
            }
            else
            {
            	msg="Record Not Updated";
            }
            
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

	//Particular Record Updated Code Below

	public String updateID(int iid) {
		
		String mssg=null;
		String sql="update oldemp_dataojt set id=? where id=?";
		
		try {
			 Scanner sc = new Scanner(System.in);
			Connection con = JdbcConnection.getConnection();
            PreparedStatement  pstm = con.prepareStatement(sql);
            
            System.out.println("Enter the ID");
            pstm.setInt(1, sc.nextInt());
            pstm.setInt(2, iid);
            int result = pstm.executeUpdate();
            
            if(result>0)
            {
            	mssg="User ID Updated";
            }
            else
            {
            	mssg="ID Not Updated";
            }
            
            
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return mssg;
	}


	//Updated Name
	public String updateName(int upName) {
	
		String mssg1=null;
		String sql="update oldemp_dataojt set name=? where id=?";
		
		try {
			 Scanner sc = new Scanner(System.in);
			Connection con = JdbcConnection.getConnection();
            PreparedStatement  pstm = con.prepareStatement(sql);
            
            System.out.println("Enter the Name");
            pstm.setString(1, sc.next());
            pstm.setInt(2, upName);
            int result = pstm.executeUpdate();
            
            if(result>0)
            {
            	mssg1="User Name Updated";
            }
            else
            {
            	mssg1="Name Not Updated";
            }
            
            
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return mssg1;
	}

//DEpartment
	
	public String updateDepartment(int upDepart) {
		
		String mssg2=null;
		String sql="update oldemp_dataojt set department=? where id=?";
		
		try {
			 Scanner sc = new Scanner(System.in);
			Connection con = JdbcConnection.getConnection();
            PreparedStatement  pstm = con.prepareStatement(sql);
            
            System.out.println("Enter the Department");
            pstm.setString(1, sc.next());
            pstm.setInt(2, upDepart);
            int result = pstm.executeUpdate();
            
            if(result>0)
            {
            	mssg2="User Department Updated";
            }
            else
            {
            	mssg2="Department Not Updated";
            }
            
            
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return mssg2;
	
	}

//Phone
	public String updatePhone(int upPhone) {
		String mssg3=null;
		String sql="update oldemp_dataojt set phone=? where id=?";
		
		try {
			 Scanner sc = new Scanner(System.in);
			Connection con = JdbcConnection.getConnection();
            PreparedStatement  pstm = con.prepareStatement(sql);
            
            System.out.println("Enter the Phone");
            pstm.setString(1, sc.next());
            pstm.setInt(2, upPhone);
            int result = pstm.executeUpdate();
            
            if(result>0)
            {
            	mssg3="User Department Updated";
            }
            else
            {
            	mssg3="Name Not Updated";
            }
            
            
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return mssg3;
	}


	public String updateCity(int upCity) {
		String mssg4=null;
		String sql="update oldemp_dataojt set city=? where id=?";
		
		try {
			 Scanner sc = new Scanner(System.in);
			Connection con = JdbcConnection.getConnection();
            PreparedStatement  pstm = con.prepareStatement(sql);
            
            System.out.println("Enter the City");
            pstm.setString(1, sc.next());
            pstm.setInt(2, upCity);
            int result = pstm.executeUpdate();
            
            if(result>0)
            {
            	mssg4="User City Updated";
            }
            else
            {
            	mssg4="City Not Updated";
            }
            
            
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return mssg4;
	}
	
	
	public String updateSalary(int upSalary)
	{
		String mssg5=null;
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = JdbcConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("update oldemp_dataojt set salary=? where id=?");
			
			System.out.println("Enther the Salary");
			pstm.setString(1, sc.next());
			pstm.setInt(2, upSalary);
			
			int result = pstm.executeUpdate();
			if(result>0)
			{
				mssg5="Salary Updated";
			}else
			{
				mssg5="Salary Not Updated";
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return mssg5;
	}

//Get Highest Salary by User
	public List<User> getHighestSalary() {
		
		List<User> listUser = new ArrayList<>();
		try {
			Connection con = JdbcConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select * from oldemp_dataojt where salary = (select max(salary) from oldemp_dataojt)");
		    
			ResultSet resultSet= pstm.executeQuery();
		    
			while(resultSet.next())
			{
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setDepartment(resultSet.getString(3));
				user.setPhone(resultSet.getString(4));
				user.setCity(resultSet.getString(5));
				user.setSalary(resultSet.getString(6));
				
				listUser.add(user);
			}
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return listUser;
	}
	
	
	//Salary Sum by Department name
	
	public List<User> departSal(String depStr) {
		
		List<User> listUser = new ArrayList<>();
		try {
			Connection con = JdbcConnection.getConnection();
			//PreparedStatement pstm = con.prepareStatement("select department,sum(salary) from oldemp_dataojt group by department");
		    
			CallableStatement callstatm = con.prepareCall("CALL list()"); //Store Procedure
			ResultSet resultSet= callstatm.executeQuery();
		    
			while(resultSet.next())
			{
				User user = new User();
				user.setDepartment(resultSet.getString(1));
				user.setSalary(resultSet.getString(2));

				
				listUser.add(user);
			}
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return listUser;
	}

}
