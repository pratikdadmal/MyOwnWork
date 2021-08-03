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
import javax.servlet.http.HttpSession;


import com.pk.configuration.DbConnection;
import com.pk.entity.ViewEmployee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/loginpage")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("View Successfull");
		
	   	
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login Successfull");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		try {
			
			Connection con = DbConnection.getConnection();
		   	PreparedStatement pstm = con.prepareStatement("select username,role,id from employee where username=? and password=?");
			pstm.setString(1, username);
			pstm.setString(2, password);
			
		   	ResultSet resultSet = pstm.executeQuery();
		   	
		   	if(resultSet.next())
		   	{	
		   		//Add login Employee Name on Navbar
		   		
		   		HttpSession session =  request.getSession();
		   		session.setAttribute("username", username);
		   		session.setAttribute("role", resultSet.getString("role"));
		   		session.setAttribute("id", resultSet.getInt("id"));
		   		
		   		//Update The UerName active status by 1
		   		PreparedStatement pstm1 = con.prepareStatement("update employee set active_status=? where username=?");
		   		pstm1.setInt(1,1);
		   		pstm1.setString(2, username);
		   		int upresult = pstm1.executeUpdate();
		   		if(upresult>=0)
		   		{
		   			System.out.println("Status Updated");
		   			
		   		}else{
		   			System.out.println("Status Not Updated");
		   		}
		   		//update Close
		   		
		   		//Role
		   		String role = resultSet.getString("role");
		   		if(role.equalsIgnoreCase("Owner"))
		   		{
		   			RequestDispatcher requestdispatcher =  request.getRequestDispatcher("manghome.jsp");
			   		requestdispatcher.forward(request, response);
		   		}
		   		else
		   		{
		   			request.setAttribute("msg", "Username and Password is Invalid!!!");
			   		RequestDispatcher requestdispatcher =  request.getRequestDispatcher("emphome.jsp");
			   		requestdispatcher.forward(request, response);
		   		}
		   		
		   	}
		   	else
		   	{
		   		request.setAttribute("msg", "Username and Password is Invalid!!!");
		   		RequestDispatcher requestdispatcher =  request.getRequestDispatcher("index.jsp");
		   		requestdispatcher.forward(request, response);
		   	}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}
