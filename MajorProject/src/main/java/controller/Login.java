package controller;

import java.io.IOException;
import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;  


import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.impl.Log4JLogger;

import model.User;
import service.UserServiceImpl;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
	private static final Logger logger = LogManager.getLogger(Login.class);  
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("in do  post");
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		User user = new User();

		user.setUserEmail(request.getParameter("email"));
		user.setUserPass(request.getParameter("password"));
		
		System.out.println("email "+user.getUserEmail());
		
		HttpSession session = request.getSession();
		session.setAttribute("email", request.getParameter("email"));		
		try {
			UserServiceImpl u = new UserServiceImpl();
			boolean result = u.login(user);
			System.out.println("result "+ result );
			

			if (result) {

				if (user.isAdmin()) {
					System.out.println("into admin page ");
					response.sendRedirect("adminDashboard.jsp");
				
				} else {

					response.sendRedirect("userDashboard.jsp");

				}
			} else {
				session.setAttribute("lerr", "Enter valid EmailId and Password!!");
				RequestDispatcher req = request.getRequestDispatcher("index.jsp");
				req.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
