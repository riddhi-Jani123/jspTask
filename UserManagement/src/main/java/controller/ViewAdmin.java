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
 * Servlet implementation class ViewAdmin
 */
public class ViewAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAdmin() {
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
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		System.out.println("email "+email);
		
		String userName =  request.getParameter("userName");
		System.out.println(userName);
		
		User user = new User();
		
		user.setUserEmail(email);
		
		
		try {
			UserService userService = new UserServiceImpl();

			AddressService addressService = new AddressServiceImpl();
			
			List<User> list  = userService.viewAdmin(user);
			
			
			List<Address> address = addressService.getData(list.get(0).getUserId());
			
			session.setAttribute("admin", list);
			
			if(!address.isEmpty()) {
			session.setAttribute("userAddress", address);
			}
			
			if(userName!=null){
				
				RequestDispatcher req = request.getRequestDispatcher("userProfile.jsp");
				req.forward(request, response);
				
				
			}
			else {
			RequestDispatcher req = request.getRequestDispatcher("viewProfile.jsp");
			req.forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		} 
		
		
		
		
		
	}

}
