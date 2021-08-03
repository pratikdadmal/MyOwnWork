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
import javax.servlet.http.HttpSession;

import com.oracle.jrockit.jfr.RequestableEvent;
import com.pk.configuration.DbConnection;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		String username= request.getParameter("username");
		String role = request.getParameter("role");
		
		
		
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select username,role from employee where username=? and role=?");
			pstm.setString(1, username);
			pstm.setString(2, role);
			
			ResultSet resultSet = pstm.executeQuery();
			
			if(resultSet.next())
			{
				HttpSession session = request.getSession();
				session.getAttribute("username");
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);
			}
			else{
			RequestDispatcher rd = request.getRequestDispatcher("emphome.jsp");
			rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
