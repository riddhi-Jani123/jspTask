package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Address;
import model.User;
import utility.DatabaseConnection;



public class AddressDaoImpl implements AddressDao {
	
	Connection connection =null;
	public AddressDaoImpl() throws ClassNotFoundException, SQLException{
		
		connection = DatabaseConnection.getInstance().getConnection();
	}
	
	

	public int addData(int id, Address a) throws SQLException {
		
		
		int result =0;
		int addID =  a.getAddressId();
		int n = a.getLength();
		
		System.out.println("length "+n);
		
		for (int i=1;i<n;i++)
		{
			
		PreparedStatement pstmt = connection
				.prepareStatement("Insert Into  Address (address, city, state, pincode,addressType,userID)"
										+ "VALUES (?,?,?,?,?,?)" );
				
	
			try {
			
				String str = a.getsAddress();
				String[] arrOfStr = str.split(" ");
				 
		     	            
				pstmt.setString(1,arrOfStr[i]);
		        
		        String str1 = a.getCity();
				String[] arrOfStr1 = str1.split(" ");
				 
		        
				pstmt.setString(2, arrOfStr1[i]);
		        
		        String str2 = a.getState();
				String[] arrOfStr2 = str2.split(" ");
				 
		        pstmt.setString(3, arrOfStr2[i]);
		        
		        String str3 = a.getPincode();
				String[] arrOfStr3 = str3.split(" ");
				 				
				pstmt.setString(4, arrOfStr3[i]);
	        
		        String str4 = a.getAddressType();
				String[] arrOfStr4 = str4.split(" ");
				 
		        
				pstmt.setString(5, arrOfStr4[i]);
				
				pstmt.setInt(6, id);
				
				result = pstmt.executeUpdate();
				
		

				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		
		}
	
		return result;
	}


	public List<Address> getData(int id) {
		// TODO Auto-generated method stub
		
		
		System.out.println(id);
		List<Address> list = new ArrayList<Address>();
		Address add ;
		
		
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from Address where userID=?");
			
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			
			int i =0;
			while(rs.next()) {
					
				
				System.out.println(rs.getString("addressType"));
				if(rs.getString("addressType").equals("Home")) {		
					add = new Address();
					add.setAddressId(Integer.parseInt(rs.getString("addressID")));					
					add.setsAddress(rs.getString("address"));
					add.setCity(rs.getString("city"));
					add.setState(rs.getString("state"));
					add.setPincode(rs.getString("pincode"));
					add.setAddressType("Home");
					
					list.add(add);
					
				}
				
				else {

					add = new Address();
					add.setAddressId(Integer.parseInt(rs.getString("addressID")));					
					add.setsAddress(rs.getString("address"));
					add.setCity(rs.getString("city"));
					add.setState(rs.getString("state"));
					add.setPincode(rs.getString("pincode"));
					add.setAddressType(rs.getString("addressType"));
					
					i++;
					list.add(add);
					
				}
				
					
			}
			
	
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("list" + list);
		
		return list;
	
	}

	public int update(int id, Address a) throws SQLException {
		// TODO Auto-generated method stub
		
		
		int result =0;
		int addID =  a.getAddressId();
		
		int n = a.getLength();

				
		
		PreparedStatement pstmt = connection
				.prepareStatement("UPDATE  Address SET address=?, city=?, state=?, pincode=?,addressType=? where userID =? and addressID =?" );
				
	
			try {
			
				String str = a.getsAddress();
				String[] arrOfStr = str.split(" ");
				 
		     	            
				pstmt.setString(1,arrOfStr[0]);
		        
		        String str1 = a.getCity();
				String[] arrOfStr1 = str1.split(" ");
				
		        
				pstmt.setString(2, arrOfStr1[0]);
				 
		        
		        String str2 = a.getState();
				String[] arrOfStr2 = str2.split(" ");
				pstmt.setString(3, arrOfStr2[0]);
				 
		     
		        String str3 = a.getPincode();
				String[] arrOfStr3 = str3.split(" ");
				
				 
		        
				
				pstmt.setString(4, arrOfStr3[0]);
		        
				
				 String str4 = a.getAddressType(); 
				 String[] arrOfStr4 = str4.split(" ");
				 
				pstmt.setString(5, arrOfStr4[0]);
				pstmt.setInt(6, id);
				pstmt.setInt(7, addID);
				
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	
		return result;
	}

	public List<Address> getId() {
		// TODO Auto-generated method stub
		
		List<Address> list = new ArrayList<Address>();
		Address add ;
		
		

			PreparedStatement pstmt;
			try {
				pstmt = connection
						.prepareStatement("select addressID from Address ");
				ResultSet rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
				
					add = new Address();
					add.setAddressId(rs.getInt("addressID"));
					list.add(add);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
			
		return list;
	}



	public int addAddress(int id, Address a) throws SQLException {
		// TODO Auto-generated method stub
		int result  =0;
			
		PreparedStatement pstmt = connection
				.prepareStatement("Insert Into  Address (address, city, state, pincode,addressType,userID)"
										+ "VALUES (?,?,?,?,?,?)" );
				

	
			try {
		      
				pstmt.setString(1,a.getsAddress());
		        
		     
		        
				pstmt.setString(2, a.getCity());
		        
				 
		        pstmt.setString(3, a.getState());
		       
				 				
				pstmt.setString(4, a.getPincode());
				 
		        
				pstmt.setString(5, a.getAddressType());
				
				pstmt.setInt(6, id);
				
				result = pstmt.executeUpdate();
				
				System.out.println("address added "+result);

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	
		return result;
	}

	/*
	 * public int addAddress(int id, Address a) throws SQLException { // TODO
	 * Auto-generated method stub int result =0; int addID = a.getAddressId(); int n
	 * = a.getLength();
	 * 
	 * for (int i=0;i<n;i++) {
	 * 
	 * PreparedStatement pstmt = connection
	 * .prepareStatement("Insert Into  Address (address, city, state, pincode,addressType,userID)"
	 * + "VALUES (?,?,?,?,?,?)" );
	 * 
	 * 
	 * 
	 * try {
	 * 
	 * String str = a.getsAddress(); String[] arrOfStr = str.split(" ");
	 * 
	 * 
	 * pstmt.setString(1,arrOfStr[i]);
	 * 
	 * String str1 = a.getCity(); String[] arrOfStr1 = str1.split(" ");
	 * 
	 * 
	 * pstmt.setString(2, arrOfStr1[i]);
	 * 
	 * String str2 = a.getState(); String[] arrOfStr2 = str2.split(" ");
	 * 
	 * pstmt.setString(3, arrOfStr2[i]);
	 * 
	 * String str3 = a.getPincode(); String[] arrOfStr3 = str3.split(" ");
	 * 
	 * pstmt.setString(4, arrOfStr3[i]);
	 * 
	 * String str4 = a.getAddressType(); String[] arrOfStr4 = str4.split(" ");
	 * 
	 * 
	 * pstmt.setString(5, arrOfStr4[i]);
	 * 
	 * pstmt.setInt(6, id);
	 * 
	 * result = pstmt.executeUpdate();
	 * 
	 * 
	 * 
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * }
	 * 
	 * return result; }
	 */


	public int deleteAddress(int id) {
		// TODO Auto-generated method stub
		
		int result=0;
		
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("delete from Address where userID=?  and Not addressType='Home' ");
			pstmt.setInt(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;

	}




	public String getRelativeId(int id) {
		// TODO Auto-generated method stub
		
		String result=null;
		System.out.println("in getrelative"+id);
		
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from user where userId=? ");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				
				result  = rs.getString("relationWith");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
		
	}



	public int updateAddress(int id, Address a) throws SQLException {
		// TODO Auto-generated method stub
		
		int result =0;
		int addID =  a.getAddressId();
		int n = a.getLength();
		
		System.out.println("length"+n);
		
		String rm = a.getRemoveId();
		
		System.out.print(rm +"remove in dao string");
		String[] removeId = rm.split(" ");
		System.out.print(removeId +"remove in dao array");
		System.out.println("rm length" +removeId.length);
		
		
		 	if(!rm.isEmpty()) {
		 	
		 	System.out.println("in delete");
		 	
		 	deleteAdd(removeId); 
		 }

		 for (int i=0;i<n;i++) {
			
			  System.out.println("in loopp");
			try {
			
			String str5 = a.getAddressIdd();
			System.out.println("str5"+str5+"hhg");
			String[] arrOfStr5 = str5.split(" ");
			System.out.println("arr of  5 "+Arrays.toString(arrOfStr5));
			System.out.println("arr"+arrOfStr5.length);
			//System.out.println("a5"+arrOfStr5[i]+"sjhj");
			
			if(arrOfStr5[i].equals("0")) {
				System.out.println("in add");
			Address address = new Address();	
			String str = a.getsAddress();
			String[] arrOfStr = str.split(" ");
			System.out.println("saddre "+Arrays.toString(arrOfStr));
			System.out.println("i"+i);
	     	System.out.println("first"+arrOfStr[i]);    
	     	System.out.println("second"+arrOfStr[i]);     
	     	address.setsAddress(arrOfStr[i]);
	        
	        String str1 = a.getCity();
			String[] arrOfStr1 = str1.split(" ");
			 
	        
			address.setCity(arrOfStr1[i]);
	        
		    String str2 = a.getState();
			String[] arrOfStr2 = str2.split(" ");
			 
			address.setState(arrOfStr2[i]);
	        
	        
	        String str3 = a.getPincode();				
	        String[] arrOfStr3 = str3.split(" ");
			
	        address.setPincode(arrOfStr3[i]);
			
   
	        String str4 = a.getAddressType();
			String[] arrOfStr4 = str4.split(" ");
			 
	        
			address.setAddressType(arrOfStr4[i]);
		
		
			addAddress(id,address);
			System.out.println("added");
			}
		
			else {
				
				System.out.println("in update");
				PreparedStatement pstmt = connection
						.prepareStatement("UPDATE  Address SET address=?, city=?, state=?, pincode=? ,addressType=? where userID =? and addressId=? ");
			String str = a.getsAddress();

			String[] arrOfStr = str.split(" ");
			System.out.println("saddre "+Arrays.toString(arrOfStr));
			System.out.println("i"+i);
	     	System.out.println("first"+arrOfStr[i]);    
	     	System.out.println("second"+arrOfStr[i]);     
			pstmt.setString(1,arrOfStr[i]);
	        
	        String str1 = a.getCity();
			String[] arrOfStr1 = str1.split(" ");
			 
	        
			pstmt.setString(2, arrOfStr1[i]);
	        
		        String str2 = a.getState();
				String[] arrOfStr2 = str2.split(" ");
			 
	        pstmt.setString(3, arrOfStr2[i]);
	        
	        String str3 = a.getPincode();				
	        String[] arrOfStr3 = str3.split(" ");
				 				
			pstmt.setString(4, arrOfStr3[i]);
    
	        String str4 = a.getAddressType();
			String[] arrOfStr4 = str4.split(" ");
			 
	        
			pstmt.setString(5, arrOfStr4[i]);
			
			
			
			pstmt.setInt(6, id);
			
			
			pstmt.setString(7, arrOfStr5[i]);
			
			
			boolean b = pstmt.execute();
			
			System.out.print("df" +b);
			/*if(!rs.next()) {
				
		
				deleteAdd(Integer.parseInt(arrOfStr5[i]));
					
			}
			*/
			
			System.out.println("end"+i);
			result = pstmt.executeUpdate();
			
			System.out.println("rs "+result);
			
			}
				
		
		
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			
		
		}
		  }
	
		return result;
	}



	public List<Address> getHomeAddress(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		List<Address> list = new ArrayList<Address>();
		Address add ;
		
		
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from Address where userID=?");
			
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			
		
			while(rs.next()) {
					
				
				System.out.println(rs.getString("addressType"));
				if(rs.getString("addressType").equals("Home")) {		
					add = new Address();
					add.setUserId(Integer.parseInt(rs.getString("userID")));
					add.setAddressId(Integer.parseInt(rs.getString("addressID")));					
					add.setsAddress(rs.getString("address"));
					add.setCity(rs.getString("city"));
					add.setState(rs.getString("state"));
					add.setPincode(rs.getString("pincode"));
					add.setAddressType("Home");
					
					list.add(add);
					
				}
				
				else {

					
					
				}
				
					
			}
			
	
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("list" + list);
		
		return list;

	}



	public List<Address> getAdminAddress(int id) {
		// TODO Auto-generated method stub
		
		
		return null;
	}


	public int deleteAdd(String id[]) {
		
		int result=0;
		for(int i=0;i<id.length;i++) {
		
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("delete from Address where addressID=? ");
			pstmt.setString(1, id[i]);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
		return result;
		
	}

	public List<Address> getAddress(Address a, int id) {
		return null;
		// TODO Auto-generated method stub
		
		
		/*Address add ;
		List<Address> list = new ArrayList<Address>();
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from Address where userID=? and address=? and city=? and state=? and pincode=?");
			
			pstmt.setInt(1,id);
			pstmt.setString(2,add.getsAddress());
			pstmt.setString(3, a.getCity());
			pstmt.setString(4, a.getState());
			pstmt.setString(5, a.getPincode());
			ResultSet rs = pstmt.executeQuery();
			
		
			while(rs.next()) {
					
						
					add = new Address();
					add.setAddressId(Integer.parseInt(rs.getString("addressID")));					
					add.setsAddress(rs.getString("address"));
					add.setCity(rs.getString("city"));
					add.setState(rs.getString("state"));
					add.setPincode(rs.getString("pincode"));
					add.setAddressType(rs.getString("addressType"));
					
					list.add(add);
					
				}
				
		return list;
	}
	}}*/

	
	}



	public int updateUser(int addressId , int relativeId) {
		// TODO Auto-generated method stub
		
		int result = 0;
		System.out.println("add id"+addressId);
		System.out.println("relative id"+relativeId);
		
		PreparedStatement pstmt;
		try {
			pstmt = connection
					.prepareStatement("UPDATE  Address SET userID=? where addressId=? ");
			pstmt.setInt(1, relativeId);
			pstmt.setInt(2,addressId);
			
			result  = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
	}



	public int deleteAdd(int id) {
		// TODO Auto-generated method stub
		
int result=0;
		
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("delete from Address where userID=?  ");
			pstmt.setInt(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;

	}



	
}
