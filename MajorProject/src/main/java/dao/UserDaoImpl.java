package dao;

import java.sql.Blob;



import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;*/

import model.User;
import utility.DatabaseConnection;

public class UserDaoImpl implements UserDao{
	
	Connection conn =null;
	public UserDaoImpl() throws ClassNotFoundException, SQLException{
		
		conn = DatabaseConnection.getInstance().getConnection();
	}
	
	public boolean login(User u) {
		// TODO Auto-generated method stub
		

				
					try {
						PreparedStatement pstmt = conn
								.prepareStatement("select * from user where email = ? and password = ?");
						pstmt.setString(1, u.getUserEmail());
						pstmt.setString(2, u.getUserPass());
						
						System.out.println("email "+u.getUserEmail());
						System.out.println("pass "+u.getUserPass());
						ResultSet rs = pstmt.executeQuery();
						
					
						if(rs.next()) {
							u.setAdmin(rs.getBoolean("isAdmin"));
							return true;
						}
						else {
							return false;
						}
						
						
					} catch (SQLException e) { // TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
			}
	public int register(User u) throws  SQLException {
		// TODO Auto-generated method stub
		
		int result=0 ;
	      
		/* Blob img= new SerialBlob(u.getImageData()); */// convert Byte array to BLOB using SerialBlob() method
	      
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("INSERT INTO user (fname, lname, email, password, gender,mobile,isAdmin)\n"
							+ "VALUES (?,?,?,?,?,?,0)");
	
				
				pstmt.setString(1,u.getUserFName());
				pstmt.setString(2,u.getUserLName());
				pstmt.setString(3,u.getUserEmail());
				pstmt.setString(4,u.getUserPass());
				pstmt.setString(5,u.getUserGender());
				/* pstmt.setString(6,u.getUserHobby()); */
				pstmt.setString(6,u.getUserMobile());
				System.out.println("first name" +u.getUserFName());
				
				
				
				/* pstmt.setBlob(8, u.getImageData()); */
				
			
				result = pstmt.executeUpdate();
			
		
				
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public List<User> getUserName() {
		// TODO Auto-generated method stub
		
		List<User> list = new ArrayList<User>();
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from user ");
			
			ResultSet rs = pstmt.executeQuery();
			
		
			while(rs.next()) {
				
				rs.getString("fname");
				
					
			}
			
	
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
		
	
	
	


	

}
