package controller;

import java.io.IOException;

import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import model.Address;
import model.User;
import service.AddressService;
import service.AddressServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import utility.DatabaseConnection;
/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final org.apache.log4j.Logger logger = Logger.getLogger(Register.class);
	Connection con = null;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		try {
			con = DatabaseConnection.getInstance().getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* super(); */
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
	
		/* static Logger logger = Logger.getLogger(Register.class.getName()); */
	
		BasicConfigurator.configure();
		logger.info("In register");
		PrintWriter out = response.getWriter();
		User user = new User();
		int result = 0;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("uId");

		Address address = new Address();
		user.setUserFName(request.getParameter("firstName"));
		user.setUserLName(request.getParameter("lname"));
		user.setUserEmail(request.getParameter("email"));
		user.setUserPass(request.getParameter("pass"));
		user.setUserMobile(request.getParameter("mNo"));
		user.setUserGender(request.getParameter("gender"));
		user.setUserCPass(request.getParameter("cpass"));

		String s  = request.getParameter("relation");
		logger.info("s = "+request.getParameter("firstName"));

	

		if (request.getParameterValues("address[]") != null) {
			String sAddress = "";
			String[] sAddresses = request.getParameterValues("address[]");
			for (int i = 0; i < sAddresses.length; i++) {
				sAddress += sAddresses[i] + " ";
			}
			

			address.setLength(sAddresses.length);
			address.setsAddress(sAddress);
			String city = "";
			String[] cities = request.getParameterValues("city[]");
			for (int i = 0; i < cities.length; i++) {
				city += cities[i] + " ";
			}

			address.setCity(city);

			String state = "";
			String[] states = request.getParameterValues("state[]");
			for (int i = 0; i < states.length; i++) {
				state += states[i] + " ";
			}
			address.setState(state);

			String addType = "";
			String[] addTypes = request.getParameterValues("addressType[]");
			for (int i = 0; i < addTypes.length; i++) {
				addType += addTypes[i] + " ";
			}
			address.setAddressType(addType);

			

			String pin = "";
			String[] pins = request.getParameterValues("pin[]");
			for (int i = 0; i < pins.length; i++) {
				pin += pins[i] + " ";
			}

			address.setPincode(pin);
		}
		String hobby = "";
		String[] hobbies = request.getParameterValues("checked");
		for (int i = 0; i < hobbies.length; i++) {
			hobby += hobbies[i] + " ";
		}

		user.setUserHobby(hobby);

		Map<String, String> message = new HashMap<String, String>();

		request.setAttribute("message", message);
		if (user.getUserFName() == " " || user.getUserFName() == "") {
			message.put("fname", "First Name is required ");
		} else if (!user.getUserFName().matches("^[a-zA-Z\\s]*$")) {
			message.put("fname", "First Name contains only alphabets");
		}
		if (user.getUserLName() == " " || user.getUserLName() == "") {
			message.put("lname", "Last Name is Required ");
		} else if (!user.getUserFName().matches("^[a-zA-Z\\s]*$")) {
			message.put("lname", "Last Name contains only alphabets");
		}
		if (user.getUserEmail() == "" || user.getUserEmail() == " ") {

			message.put("email", "Email  is required");
		} else if (!user.getUserEmail().matches(
				"^(?=.{1,64}@)[A-Za-z0-9_-]+(.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(.[A-Za-z0-9-]+)*(.[A-Za-z]{2,})$")) {

			message.put("email", "The email should be in the format: abc@domain.tld");
		}

		if (user.getUserMobile().length() == 0) {
			message.put("mNo", "Mobile Number is required");

		} else if (!user.getUserMobile().matches("^\\d{10}$")) {

			message.put("mNo", "Please enter valid mobile number");
		}

		if (user.getUserPass().length() == 0) {

			message.put("pass", "Password is required");
		} else if (user.getUserPass().length() < 8) {

			message.put("pass", "Please enter atleast  8 character");
		}

		System.out.println("pass"+user.getUserPass());
		System.out.println("cpass"+user.getUserCPass());
		if (!user.getUserCPass().equals(user.getUserCPass())) {

			
			message.put("cpass", "password and confirm password must be same ");

		}

		if (message.isEmpty()) {
			
			try {

				UserService u = new UserServiceImpl();

				AddressService a = new AddressServiceImpl();

				
				result = u.register(user);
				if(address.getLength() != 0) {
					String str = address.getAddressType();
					String[] arrOfStr = str.split(" ");
				for (int i = 0; i < address.getLength(); i++) {
					System.out.print("addtype" + arrOfStr[i]);
					if (arrOfStr[i].equals("Home")) {
						

						if ((Integer) session.getAttribute("addrID") == null) {

							a.addAddress(result, address);

							
						} else {
							int aId = (Integer) session.getAttribute("addrID");
							
							address.setAddressId(aId);
							user.setRelativeId(Integer.parseInt(id));
							int Id = 0;
							if (id != null) {
								Id = Integer.parseInt(id);

								a.updateData(Id, address);
							}

						}
					} else {

						
						a.addData(result, address);
					}
				}
				}

				response.sendRedirect("index.jsp");
			} catch (ClassNotFoundException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) { // TODO Auto-generated catch
				e.printStackTrace();
			}

		} else {

			RequestDispatcher req = request.getRequestDispatcher("register.jsp");
			req.forward(request, response);

		}
	}

}
