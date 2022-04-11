package controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import model.Address;
import model.User;
import service.AddressService;
import service.AddressServiceImpl;
import service.UserService;
import service.UserServiceImpl;

/**
 * Servlet implementation class getUserName
 */
public class getUserName extends HttpServlet {
	private static final org.apache.log4j.Logger logger = Logger.getLogger(Register.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getUserName() {
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

		BasicConfigurator.configure();
		
		try {

			String id = request.getParameter("userId");
			logger.info("id"+id);
			UserService u = new UserServiceImpl();
			List<User> user = u.getUserName();

			HttpSession session = request.getSession();
			session.setAttribute("users", user);

			if(id != null) {
				
				
				session.setAttribute("uId", id);
				AddressService address = new AddressServiceImpl();
				List<Address> addr = address.getHomeAddress(Integer.parseInt(id));

			
			
				if (!addr.isEmpty()) {
				
					Address addrr = addr.get(0);

					session.setAttribute("addrID", addrr.getAddressId());
					session.setAttribute("addr", addr);
					request.setAttribute("home", "true");
				}
				
			}
			RequestDispatcher req = request.getRequestDispatcher("register.jsp");
			req.forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
