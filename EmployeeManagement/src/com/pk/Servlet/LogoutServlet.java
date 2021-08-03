package com.pk.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pk.configuration.DbConnection;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		     
		   String username =  request.getParameter("logout");
		
		try {
			Connection con = DbConnection.getConnection();
			
			PreparedStatement pstm1 = con.prepareStatement("update employee set active_status=? where username=?");
	   		pstm1.setInt(1,0);
	   		pstm1.setString(2, username);
	   		
	   	   pstm1.executeUpdate();
	   		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		RequestDispatcher requestdispatcher =  request.getRequestDispatcher("index.jsp");
   		requestdispatcher.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
