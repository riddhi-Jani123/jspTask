package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		// TODO Auto-generated method stub
		
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
				// TODO Auto-generated catch block
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
					
					add.setAddressType("office");
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
		int result =0;
		int addID =  a.getAddressId();
		int n = a.getLength();
		
		for (int i=0;i<n;i++)
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
	
		return result;
	}

	
	

}
