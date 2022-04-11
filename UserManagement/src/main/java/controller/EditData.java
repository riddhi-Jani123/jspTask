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

import model.Address;
import model.User;
import service.AddressService;
import service.AddressServiceImpl;
import service.UserService;
import service.UserServiceImpl;

/**
 * Servlet implementation class EditData
 */
public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditData() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String email = (String) session.getAttribute("email");
		
		User user = new User();
		Address address  = new Address();
		user.setUserEmail(email);
		UserService userService;
		AddressService  addressService ;
		try {
			userService = new UserServiceImpl();
			addressService = new AddressServiceImpl();
			
			String profile  = request.getParameter("profile");
			request.setAttribute("profile", profile);
			List<User> list  = userService.viewAdmin(user);
			
			session.setAttribute("userList", list);
			
			user = list.get(0);
			
		
			
			System.out.println("userList"+list);
			
			int userId = user.getUserId();
			List<Address> addressList   = addressService.getData(userId);
			
			System.out.println(addressList);
			
			session.setAttribute("addr", addressList);
			
			
			System.out.println("hobby "+user.getUserHobby());
			
			//String relativeId = addressService.getRelativeId();
			
			RequestDispatcher req = request.getRequestDispatcher("register.jsp");
			req.include(request, response);

			
			//user  = list.get(0);
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
