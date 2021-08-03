package com.pk.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	private static Connection con=null;
	
	public static Connection getConnection() throws SQLException
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvc","root","root");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
		
	}

}
