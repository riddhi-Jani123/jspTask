package controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import model.Address;
import service.AddressService;
import service.AddressServiceImpl;
import service.UserService;
import service.UserServiceImpl;

/**
 * Servlet implementation class DeleteRecord
 */
public class DeleteRecord extends HttpServlet {
	private static final org.apache.log4j.Logger logger = Logger.getLogger(DeleteRecord.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BasicConfigurator.configure();
		logger.info("In delete");
		logger.info("delete" + request.getParameter("deleteid"));
		String id = request.getParameter("deleteid");

		try {

			UserService user = new UserServiceImpl();
			AddressService address = new AddressServiceImpl();

			
			//get user relative  id
			String relativeId = address.getRelativeId(Integer.parseInt(id));
			
			
			List<Address> isExistHome =  address.getHomeAddress(Integer.parseInt(id));
			
			if(relativeId!=null) {
				
				if(!isExistHome.isEmpty()) {
					
					int addressId = isExistHome.get(0).getAddressId();
					int result =address.updateUser(addressId, Integer.parseInt(relativeId));
					logger.info("affected"+result);
					
					int affected = user.deleteID(Integer.parseInt(relativeId) ,Integer.parseInt(id));
					
					logger.info("relation deleted " + affected);
					
					int resultt =	address.deleteAddress(Integer.parseInt(id));
					logger.info(" address deleted "+resultt);
				}
				
	
		
			}
			else {
			
				
				int result = address.deleteAdd(Integer.parseInt(id));
				logger.info(" all address deleted "+result);
				
			}
			
			
			
					
			int ans = user.deleteRecord(Integer.parseInt(id));
			logger.info("user record deleted " + ans); 
			logger.info("success");
			/*if(relativeId!=null) {
			String[] arrOfStr = relativeId.split("," );
			 
			logger.info("relative id " + Arrays.toString(arrOfStr));
*/
			/*
			if (arrOfStr.length!=0) {
				
				int count=0;
				for(int i=0;i<arrOfStr.length;i++) {
					
					String Id= arrOfStr[i]; 
				int ans = user.deleteID(Integer.parseInt(Id) ,Integer.parseInt(id));
				logger.info("affected id " + ans);
				int res = address.deleteAddress(Integer.parseInt(Id) );

				logger.info("affected " + res);*/
//				
//				boolean b = user.existRecord(Integer.parseInt(Id));
//				if(b) {
//					count++;
//					
//				}
//				if(count==0) {
//					
//				int result =	address.deleteAddress(Integer.parseInt(Id));
//				logger.info("Home address deleted "+result);
//				}
				
			/*
			 * }
			 * 
			 * } }
			 * 
			 * logger.info("idd" + Integer.parseInt(id)); int res =
			 * address.deleteAddress(Integer.parseInt(id)); logger.info("affected " + res);
			 * int result = user.deleteRecord(Integer.parseInt(id)); logger.info("result" +
			 * result); logger.info("success");
			 */
			
			
		} catch (Exception e) {

			logger.info(e);
			e.printStackTrace();
		}
	}

}
