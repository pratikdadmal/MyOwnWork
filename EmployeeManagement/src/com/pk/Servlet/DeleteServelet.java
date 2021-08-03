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

@WebServlet("/DeleteServelet")
public class DeleteServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("delete from employee where id=?");
			pstm.setInt(1, id);
			int result = pstm.executeUpdate();
			
			if(result>0)
			{
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("ViewEmployee.jsp");
				requestdispatcher.forward(request, response);
			}
			else
			{
				request.setAttribute("deleteMsg", "Employee Record Not Deleted");
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("manghome.jsp");
				requestdispatcher.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
