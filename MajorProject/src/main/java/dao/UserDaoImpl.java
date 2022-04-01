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
	
	Connection connection =null;
	public UserDaoImpl() throws ClassNotFoundException, SQLException{
		
		connection = DatabaseConnection.getInstance().getConnection();
	}
	
	public boolean login(User u) {
		// TODO Auto-generated method stub
		

				
					try {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from user where email = ? and password = ?");
						pstmt.setString(1, u.getUserEmail());
						pstmt.setString(2, u.getUserPass());
						
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
		
		int result = 0 ;
		int id =0;
	      
		/* Blob img= new SerialBlob(u.getImageData()); */// convert Byte array to BLOB using SerialBlob() method
	      
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("INSERT INTO user (fname, lname, email, password, gender,relationwith,hobby,mobile,isAdmin)\n"
							+ "VALUES (?,?,?,?,?,?,?,?,0)");
	
		
				pstmt.setString(1,u.getUserFName());
				pstmt.setString(2,u.getUserLName());
				pstmt.setString(3,u.getUserEmail());
				pstmt.setString(4,u.getUserPass());
				pstmt.setString(5,u.getUserGender());
				pstmt.setInt(6,u.getRelativeId()); 
				pstmt.setString(7,u.getUserHobby()); 
				pstmt.setString(8,u.getUserMobile());
				
				/* pstmt.setBlob(8, u.getImageData()); */
				
				
				result = pstmt.executeUpdate();
				
				
		 pstmt = connection
							.prepareStatement("select * from user ");
					
					ResultSet rs = pstmt.executeQuery();
					
				
					while(rs.next()) {
						
				
						id = rs.getInt("userId");
							
					}
					
			
				} 
		catch (SQLException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return id;
	}
	public List<User> getUserName() {
		// TODO Auto-generated method stub
		
		List<User> list = new ArrayList<User>();
		User user ;
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from user where isAdmin=0  ");
			
			ResultSet rs = pstmt.executeQuery();
			
		
			while(rs.next()) {
				
				rs.getString("fname");
				
					user = new User();
					user.setUserFName(rs.getString("fname"));
					user.setUserId(rs.getInt("userId"));
					list.add(user);
			}
			
	
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("list" + list);
		
		return list;
	}

	public int getId() {
		// TODO Auto-generated method stub
		
		int id =0;
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from user ");
			
			ResultSet rs = pstmt.executeQuery();
			
		
			while(rs.next()) {
				
		
				id = rs.getInt("userId");
					
			}
			
	
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public List<User> getData() {
		// TODO Auto-generated method stub
		
		List<User> list = new ArrayList<User>();
		User user;
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from user");
			
			ResultSet rs = pstmt.executeQuery();
			
		
			while(rs.next()) {
				
			
					user = new User();
					user.setUserFName(rs.getString("fname"));
					user.setUserLName(rs.getString("lname"));
					user.setUserEmail(rs.getString("email"));
					user.setUserPass(rs.getString("password"));
					user.setUserGender(rs.getString("gender"));
					user.setUserHobby(rs.getString("hobby"));
					user.setUserMobile(rs.getString("mobile"));
					user.setUserId(rs.getInt("userId"));
					
					list.add(user);
			
			}
			
	
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println("list" + list);
		
		return list;
	
	}

	public int updatePass(User user) {
		// TODO Auto-generated method stub
		
		int result = 0;
		
		try {
			PreparedStatement pstmt = connection.prepareStatement("UPDATE  user SET password=?  where email=? " );
			
			pstmt.setString(1, user.getUserPass());
			pstmt.setString(2, user.getUserEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

				
		return result;
	}

	public List<User> viewAdmin(User user) {
		// TODO Auto-generated method stub
		
		
		List<User> list = new ArrayList<User>();
		
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from user where email=? and isAdmin=1");
			
			pstmt.setString(1, user.getUserEmail());
			
			ResultSet rs = pstmt.executeQuery();
			
		
			while(rs.next()) {
				
			
					user = new User();
					user.setUserFName(rs.getString("fname"));
					user.setUserLName(rs.getString("lname"));
					user.setUserEmail(rs.getString("email"));
					user.setUserPass(rs.getString("password"));
					user.setUserGender(rs.getString("gender"));
					user.setUserHobby(rs.getString("hobby"));
					user.setUserMobile(rs.getString("mobile"));
					user.setUserId(rs.getInt("userId"));
					
					list.add(user);
			
			}
			
	
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println("list" + list);
		
		return list;
	
	}
		
	
	
	


	

}
