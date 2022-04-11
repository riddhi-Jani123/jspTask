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
 * Servlet implementation class getData
 */
public class getData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("userId");
		int userIdd = Integer.parseInt(userId);
		
		System.out.println("uid"+userIdd);
		try {
			UserService userService = new UserServiceImpl();
			
			List<User>  userList = userService.getDetails(Integer.parseInt(userId));
			
			AddressService addressService = new AddressServiceImpl();
			
			List<Address> addressList   = addressService.getData(Integer.parseInt(userId));
			
			HttpSession session = request.getSession();
			
			User user  = userList.get(0);
			System.out.print("user"+user);
			
			session.setAttribute("userInfo", user);

			session.setAttribute("addr", addressList);
			session.setAttribute("userId", userIdd);
			
			RequestDispatcher req = request.getRequestDispatcher("register.jsp?profile=user&goesInto=admin");
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
