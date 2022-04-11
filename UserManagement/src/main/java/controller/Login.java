package controller;

import java.io.IOException;



import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.impl.Log4JLogger;

import model.Address;
import model.User;
import service.AddressService;
import service.AddressServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import utility.Password_Encrypt_Decrypt;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
	
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
		
		try {
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		User user = new User();
		Address address = new Address();
		user.setUserEmail(request.getParameter("email"));
		String password = request.getParameter("password");
		
		byte[] encryptionBytes = Password_Encrypt_Decrypt.encrypt(password);
		String pass = new String(encryptionBytes);
		user.setUserPass(pass);

		HttpSession session = request.getSession();
		session.setAttribute("email", request.getParameter("email"));		
		session.setAttribute("pass",request.getParameter("password"));
		
		
		try {
			UserService u = new UserServiceImpl();
			AddressService addressService = new AddressServiceImpl();
			boolean result = u.login(user);
			
			user.setUserEmail(request.getParameter("email"));
			user.setUserPass(request.getParameter("password"));
			int userId = user.getUserId();
			
			
			List<Address> addressList   = addressService.getData(userId);
			
			System.out.println(addressList.size());
			
			address.setLength(addressList.size());
			
			session.setAttribute("length", address.getLength());
			
			System.out.println(addressList);
			
			
			if (result) {

				if (user.isAdmin()) {
					
					
					response.sendRedirect("adminDashboard.jsp");
				
				} else {
					
					System.out.println("user"+user);
					session.setAttribute("userId", userId);
					session.setAttribute("userInfo", user);

					session.setAttribute("addr", addressList);
					response.sendRedirect("userDashboard.jsp");

				}
			} else {
				request.setAttribute("lerr", "Enter valid EmailId and Password!!");
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
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}
