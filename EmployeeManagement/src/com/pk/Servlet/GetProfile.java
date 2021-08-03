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

@WebServlet("/getProfile")
public class GetProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetProfile() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				viewemployee.setEmail(resultSet.getString("email"));
				viewemployee.setRole(resultSet.getString("role"));
				viewemployee.setManager_name(resultSet.getString("manager_name"));
				
				request.setAttribute("profile", viewemployee);
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);
			}
			
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
