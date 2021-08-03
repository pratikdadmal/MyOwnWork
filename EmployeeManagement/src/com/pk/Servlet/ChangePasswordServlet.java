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

import com.pk.configuration.DbConnection;

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("update employee set password=? where username=?");
			pstm.setString(2, username);
			pstm.setString(1, password);
			
			int cpass = pstm.executeUpdate();
			if(cpass > 0)
			{
				request.setAttribute("msg", "Password changed Successfully !!");
				RequestDispatcher res = request.getRequestDispatcher("ForgetPassword.jsp");
				res.forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "Password Not Changed !!");
				RequestDispatcher res = request.getRequestDispatcher("ForgetPassword.jsp");
				res.forward(request, response);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
