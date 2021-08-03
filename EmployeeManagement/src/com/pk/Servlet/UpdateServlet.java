package com.pk.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pk.configuration.DbConnection;
import com.pk.entity.ViewEmployee;

@WebServlet("/updateEmployee")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
/*		 int id = Integer.parseInt(request.getParameter("id"));
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 String email = request.getParameter("email");
		 String role = request.getParameter("role");
		 String task = request.getParameter("task");
		 String manager_name = request.getParameter("manager_name");
		
		 
		 try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("update employee set username=?, password=?, email=?, role=?, task=?, manager_name=? where id=?");
			pstm.setString(1, username);
		    pstm.setString(2, password);
		    pstm.setString(3, email);
		    pstm.setString(4, role);
		    pstm.setString(5, task);
		    pstm.setString(6, manager_name);
		    pstm.setInt(7, id);
		    

			int resultID = pstm.executeUpdate();
		
			if(resultID > 0)
			{
				ViewEmployee viewemployee = new ViewEmployee();
				request.setAttribute("update", viewemployee);
				RequestDispatcher req = request.getRequestDispatcher("UpdatedEmployee.jsp");
				req.forward(request, response);
			}
			else
			{
				request.setAttribute("update", "Record Not Updated");
				RequestDispatcher req = request.getRequestDispatcher("UpdatedEmployee.jsp");
				req.forward(request, response);
			}
			System.out.println("Updated Working");
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Connection con = DbConnection.getConnection();
			
			PreparedStatement pstm = con.prepareStatement("Select * from employee where id=?");
			pstm.setInt(1, id);
			ResultSet resultSet = pstm.executeQuery();
			if(resultSet.next())
			{
				ViewEmployee viewemployee = new ViewEmployee();
				viewemployee.setId(resultSet.getInt("id"));
				viewemployee.setUsername(resultSet.getString("username"));
				viewemployee.setUsername(resultSet.getString("password"));
				viewemployee.setEmail(resultSet.getString("email"));
				viewemployee.setRole(resultSet.getString("role"));
				viewemployee.setRole(resultSet.getString("task"));
				viewemployee.setManager_name(resultSet.getString("manager_name"));
				
				request.setAttribute("update", viewemployee);
				RequestDispatcher rd = request.getRequestDispatcher("ViewEmployee.jsp");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		doGet(request, response);
	}

}
