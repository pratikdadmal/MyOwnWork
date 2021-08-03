package com.pk.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pk.configuration.DbConnection;
import com.pk.entity.ViewEmployee;

/**
 * Servlet implementation class ViewEmployeeServelet
 */
@WebServlet("/viewEmployee")
public class ViewEmployeeServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Connection con;
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select * from employee");
			ResultSet resultSet =  pstm.executeQuery();
			
			List<ViewEmployee> empList =  new ArrayList<>();
			
			while(resultSet.next())
			{
				ViewEmployee viewemployee =  new ViewEmployee();
				viewemployee.setId(resultSet.getInt("id"));
				viewemployee.setUsername(resultSet.getString("username"));
				viewemployee.setPassword(resultSet.getString("password"));
				viewemployee.setEmail(resultSet.getString("email"));
				viewemployee.setRole(resultSet.getString("role"));
				viewemployee.setActive_status(resultSet.getInt("active_status"));
				viewemployee.setTask(resultSet.getString("task"));
				viewemployee.setManager_name(resultSet.getString("manager_name"));
				
				//boolean list = empList.add(viewemployee);
				empList.add(viewemployee);
			}
//			    if(list)
				if(!empList.isEmpty())
			    {
			    	request.setAttribute("employees", empList);
			   		RequestDispatcher requestdispatcher =  request.getRequestDispatcher("manghome.jsp");
			   		requestdispatcher.forward(request, response);
			    }
			    else
			    {
			    	request.setAttribute("empListMsg", "Data Not Found!!!");
			   		RequestDispatcher requestdispatcher =  request.getRequestDispatcher("manghome.jsp");
			   		requestdispatcher.forward(request, response);
			    }
			    
			   
			
			
			 System.out.println("View Work");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
