package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

/**
 * Servlet implementation class updateData
 */
@MultipartConfig

public class updateData extends HttpServlet {
	private static final org.apache.log4j.Logger logger = Logger.getLogger(updateData.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateData() {
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

			BasicConfigurator.configure();
			logger.info("In register");
			PrintWriter out = response.getWriter();
			User user = new User();
			int result = 0;
			HttpSession session = request.getSession();

			// add users list into relative
			String id = (String) session.getAttribute("uId");

			String userName = (String) session.getAttribute("userName");

			logger.info("username  " + userName);

			logger.info("id" + id);
			String fname = request.getParameter("firstName");
			System.out.println("first " + fname);
			Address address = new Address();
			user.setUserFName(request.getParameter("firstName"));
			user.setUserLName(request.getParameter("lname"));
			user.setUserEmail(request.getParameter("email"));
//			String password = request.getParameter("pass");
//
//			
//			byte[] encryptionBytes = utility.Password_Encrypt_Decrypt.encrypt(password);
//			String pass = new String(encryptionBytes);
//			user.setUserPass(pass);
			user.setUserMobile(request.getParameter("mNo"));
			user.setUserGender(request.getParameter("gender"));
//			user.setUserCPass(request.getParameter("cpass"));

			Part file = request.getPart("image");
			InputStream imgContent = file.getInputStream();
			user.setImage(imgContent);

			String s = request.getParameter("relation");
			logger.info("s = " + request.getParameter("firstName"));

			if (request.getParameterValues("address[]") != null) {
				String sAddress = "";
				String[] sAddresses = request.getParameterValues("address[]");
				for (int i = 0; i < sAddresses.length; i++) {
					sAddress += sAddresses[i] + " ";
				}
				System.out.println("address" + sAddresses[0]);
				address.setLength(sAddresses.length);
				
				System.out.println("ln"+sAddresses.length);
			
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

				String addressId = "";
				String[] addressIds = request.getParameterValues("addressId[]");
				System.out.println("ids" + Arrays.toString(addressIds));
				
				for (int i = 0; i < addressIds.length; i++) {
					
					if(addressIds[i].isEmpty()) {
						
						addressId += "0" + " ";
					}
					else {
					addressId += addressIds[i] + " ";
					}
				}

				System.out.println("update data ni id "+addressId);
				address.setAddressIdd(addressId);

				System.out.println("addid " + addressId);

				List<Address> addrr = (List<Address>) session.getAttribute("addr");
				System.out.println("xc" + addrr);
				
				Address addressss = addrr.get(0);
				
				System.out.println("addid  "+addressss.getAddressId());
				
				int[] addidd = new int[addrr.size()];
				for (int i = 0; i < addidd.length; i++) {
					addidd[i] =  addrr.get(i).getAddressId();
				}
				
				String[] straddidd = new String[addrr.size()];
				for (int i = 0; i < addidd.length; i++) {
					straddidd[i] = String.valueOf(addidd[i]);
		        }

				System.out.println("adddd"+Arrays.toString(straddidd));
		
				List<String> list = Arrays.asList(addressIds);
				String remove = "";
				for (int i = 0; i < addidd.length; i++) {

					if(!list.contains(straddidd[i])) {
						
						remove += straddidd[i] + " ";
					}
					
				}
				
				String[] removeId  = remove.split(" ");
				
				System.out.println("removeid in servlet "+remove);
				
				address.setRemoveId(remove);
				
				System.out.println("removeid"+Arrays.toString(removeId));
			}

			UserService u;
			AddressService a;

			int uId = (Integer) session.getAttribute("userId");

	

			try {

				u = new UserServiceImpl();
				a = new AddressServiceImpl();

				a.getAddress(address, uId);
				int resultt = u.update(user);
				System.out.println("address" + address.getsAddress());
				int affetedRow = a.updateAddress(uId, address);
				System.out.println("result "+affetedRow);
				if (resultt > 0) {
					String profilee =  (String) session.getAttribute("profilee");
					if(profilee !=null) {
						RequestDispatcher req = request.getRequestDispatcher("adminDashboard.jsp");
						req.forward(request, response);
						
					}
					else {

					RequestDispatcher req = request.getRequestDispatcher("userDashboard.jsp");
					req.forward(request, response);
					}

				}
				System.out.println(resultt);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generaSSted catch block
				e.printStackTrace();
			}


		}

		catch (Exception e) {

			System.out.println(e);
		}

	}

}
