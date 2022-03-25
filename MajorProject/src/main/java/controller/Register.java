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
		Address address = new Address();
		user.setUserFName(request.getParameter("fname"));
		user.setUserLName(request.getParameter("lname"));
		user.setUserEmail(request.getParameter("email"));
		user.setUserPass(request.getParameter("pass"));
		user.setUserMobile(request.getParameter("mNo"));
		user.setUserGender(request.getParameter("gender"));
		
		System.out.println(user.getUserFName());
//		address.setsAddress(request.getParameter("address"));
		//address.setPincode(Integer.parseInt(request.getParameter("pin")));
//		address.setCity(request.getParameter("city"));
//		address.setState(request.getParameter("state"));
		
		//address.setPincode(Integer.parseInt(request.getParameter("pin")));
		/*
		 * String hobby = ""; String[] hobbies = request.getParameterValues("checked");
		 * for (int i = 0; i < hobbies.length; i++) { hobby += hobbies[i] + " "; }
		 * 
		 * user.setUserHobby(hobby);
		 */
		/*
		 * user.setUserHobby(hobby); Part filePart = request.getPart("image");
		 * InputStream img = filePart.getInputStream(); user.setImageData(img);
		 * 
		 */
		
		  try {
			  
		
		  UserServiceImpl u = new UserServiceImpl(); 
		  
//		  AddressServiceImpl a = new AddressServiceImpl();
		
		  
		 int result = u.register(user); 
//		 int addResult = a.addData(user, address);
		 
		 if(result>0 )  {
		  response.sendRedirect("index.jsp");
		  
		 }
		  
		  else { out.println("not affected"); }
		  
		  }
		  catch(
		  
		  ClassNotFoundException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		  catch( SQLException e) { // TODO Auto-generated catch
		   e.printStackTrace(); }
		 
	}

}
