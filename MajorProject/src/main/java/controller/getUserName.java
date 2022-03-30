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
import service.AddressServiceImpl;
import service.UserServiceImpl;

/**
 * Servlet implementation class getUserName
 */
public class getUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getUserName() {
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
		
		try {
			
			
			String id = request.getParameter("userId");
			
			System.out.println("id "+id);
			
			UserServiceImpl u = new UserServiceImpl();
			List<User> user  = u.getUserName();
			System.out.println(user);
			HttpSession session = request.getSession();
			session.setAttribute("users", user);
			
			
			
			if(id!=null) {
			
				
			session.setAttribute("uId", id);
			AddressServiceImpl address = new AddressServiceImpl();
			List<Address> addr = address.getData(Integer.parseInt(id));
			System.out.println("address" +addr);
			Address addrr = addr.get(0);
			System.out.println(addrr.getAddressType());
			/*if(addrr.getAddressType().equals("Home"))
			{*/
				
				
				//System.out.println("address id "+addrr.getAddressId());
				session.setAttribute("addrID", addrr.getAddressId());
				session.setAttribute("addr", addr);
				
					
			//}
			/*
			 * else { session.setAttribute("addrID", addrr.getAddressId());
			 * System.out.println("Another Address Type");
			 * 
			 * } }
			 */
			}
			RequestDispatcher req = request.getRequestDispatcher("register.jsp");
				req.forward(request, response);
		
		
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
