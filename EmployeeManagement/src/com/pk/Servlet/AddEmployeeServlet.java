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

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;

import com.pk.configuration.DbConnection;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		//String active_status = request.getParameter("active_status");
		String task = request.getParameter("task");
		String manager_name = request.getParameter("manager_name");
		
		
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstm =  con.prepareStatement("insert into employee(username,password,email,role,task,manager_name) values(?,?,?,?,?,?)");
		    
		   // pstm.setInt(1, id);
			pstm.setString(1, username);
			pstm.setString(2, password);
			pstm.setString(3, email);
			pstm.setString(4, role);
			pstm.setString(5, task);
			pstm.setString(6, manager_name);
			
		    int result = pstm.executeUpdate();
		    
		    if(result>0)
		    {
		    	RequestDispatcher requestd =  request.getRequestDispatcher("manghome.jsp");
     			requestd.forward(request, response);
		    }
			
		    else
		    {
		    	request.setAttribute("addmsg","Fill The All Fields");
				RequestDispatcher requestd =  request.getRequestDispatcher("addEmployee.jsp");
				requestd.forward(request, response);
		    }
//			if(username.isEmpty() || password.isEmpty() || email.isEmpty() || role.isEmpty() || task.isEmpty() || manager_name.isEmpty())
//			{
//				request.setAttribute("addmsg","Fill The All Fields");
//				RequestDispatcher requestd =  request.getRequestDispatcher("addEmployee.jsp");
//				requestd.forward(request, response);
//			}
//			else
//			{
//				
//     			RequestDispatcher requestd =  request.getRequestDispatcher("manghome.jsp");
//				requestd.forward(request, response);
//			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
