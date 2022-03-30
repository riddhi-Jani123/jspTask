package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
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

import model.Address;
import model.User;
import service.AddressServiceImpl;
import service.UserServiceImpl;
import utility.DatabaseConnection;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
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

		System.out.println(request.getParameter("relation"));

		// String[] add = request.getParameterValues("limit[]");

		System.out.println("first name " + request.getParameter("firstName"));
		System.out.println(user.getUserFName());

		String sAddress = "";
		String[] sAddresses = request.getParameterValues("address[]");
		for (int i = 0; i < sAddresses.length; i++) {
			sAddress += sAddresses[i] + " ";
		}
		System.out.println("address number " + sAddresses.length);

		address.setLength(sAddresses.length);
		address.setsAddress(sAddress);
//		address.setsAddress(request.getParameter("address"));
		// address.setPincode(Integer.parseInt(request.getParameter("pin[]")));
		String city = "";
		String[] cities = request.getParameterValues("city[]");
		for (int i = 0; i < cities.length; i++) {
			city += cities[i] + " ";
		}

		address.setCity(city);
		// address.setCity(request.getParameter("city[]"));

		String state = "";
		String[] states = request.getParameterValues("state[]");
		for (int i = 0; i < states.length; i++) {
			state += states[i] + " ";
		}
		address.setState(state);

		// address.setState(request.getParameter("state[]"));

		String addType = "";
		String[] addTypes = request.getParameterValues("addressType[]");
		for (int i = 0; i < addTypes.length; i++) {
			addType += addTypes[i] + " ";
		}
		address.setAddressType(addType);

		// address.setAddressType(request.getParameter("addressType[]"));
//		
		System.out.println("address " + addTypes);
//		

		String pin = "";
		String[] pins = request.getParameterValues("pin[]");
		for (int i = 0; i < pins.length; i++) {
			pin += pins[i] + " ";
		}

		address.setPincode(pin);
//		
		String hobby = "";
		String[] hobbies = request.getParameterValues("checked");
		for (int i = 0; i < hobbies.length; i++) {
			hobby += hobbies[i] + " ";
		}

		user.setUserHobby(hobby);

		/*
		 * user.setUserHobby(hobby); Part filePart = request.getPart("image");
		 * InputStream img = filePart.getInputStream(); user.setImageData(img);
		 * 
		 */

		try {

			UserServiceImpl u = new UserServiceImpl();

			AddressServiceImpl a = new AddressServiceImpl();

			// int id = u.getId();
			// user.setUserId(id);
			String str = address.getAddressType();
			String[] arrOfStr = str.split(" ");
			result = u.register(user);
			for (int i = 0; i < sAddresses.length; i++) {
				System.out.print("addtype" + arrOfStr[i]);
				if (arrOfStr[i].equals("Home")) {
					System.out.println("in home");
					
					if((Integer) session.getAttribute("addrID")== null)
					{
						/*
						 * int aId = (Integer) session.getAttribute("addrID"); System.out.println(aId);
						 * address.setAddressId(aId);
						 */
				
						
						System.out.println("Address id not assigned ");
					}
					else {
						 int aId = (Integer) session.getAttribute("addrID"); System.out.println(aId);
						 address.setAddressId(aId);
					user.setRelativeId(Integer.parseInt(id));
					int Id = 0;
					if (id != null) {
						Id = Integer.parseInt(id);
						
						

						a.updateData(Id, address);
					}
						
					}
				} 
				else {
					
					System.out.println("not in home");
					a.addData(result, address);
				}
			}

			response.sendRedirect("index.jsp");
		}

		catch (

		ClassNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) { // TODO Auto-generated catch
			e.printStackTrace();
		}

	}

}
