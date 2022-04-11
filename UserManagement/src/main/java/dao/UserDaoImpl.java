package dao;


import java.sql.Blob;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

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
		
		

				
					try {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from user where email = ? and password = ?");
						pstmt.setString(1, u.getUserEmail());
						pstmt.setString(2, u.getUserPass());
						
						ResultSet rs = pstmt.executeQuery();
						
					
						if(rs.next()) {
							u.setUserId(rs.getInt("userId"));
							u.setUserFName(rs.getString("fname"));
							u.setUserLName(rs.getString("lname"));
							u.setUserGender(rs.getString("gender"));
							u.setUserHobby(rs.getString("hobby"));
							u.setUserMobile(rs.getString("mobile"));
							Blob blob = rs.getBlob("image");

							byte[] photo = blob.getBytes(1, (int) blob.length());
							String base64Image = Base64.getEncoder().encodeToString(photo);
							u.setBase64image(base64Image);
							u.setAdmin(rs.getBoolean("isAdmin"));
							return true;
						}
						else {
							return false;
						}
						
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return false;
			}
	
	public String relativeExist(String email) {
		
		String id  = null;
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select relationwith from user where email = ? ");
			
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
		
				id = rs.getString("relationwith");
					
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	public int register(User u) throws  SQLException {
		
		
		String relativeId= relativeExist(u.getUserEmail());
		if(relativeId!=null) {
			
			u.setRelativeId(relativeId);
		}
		
		int result = 0 ;
		int id =0;
	      
		/* Blob img= new SerialBlob(u.getImageData()); */// convert Byte array to BLOB using SerialBlob() method
		
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("INSERT INTO user (fname, lname, email, password, gender,image,relationwith,hobby,mobile,isAdmin)\n"
							+ "VALUES (?,?,?,?,?,?,?,?,?,0)");
	
		
				pstmt.setString(1,u.getUserFName());
				pstmt.setString(2,u.getUserLName());
				pstmt.setString(3,u.getUserEmail());
				pstmt.setString(4,u.getUserPass());
				pstmt.setString(5,u.getUserGender());
				pstmt.setBlob(6,u.getImage());
				pstmt.setString(7,u.getRelativeId()); 
				pstmt.setString(8,u.getUserHobby()); 
				pstmt.setString(9,u.getUserMobile());
				
				/* pstmt.setBlob(8, u.getImageData()); */
				
				
				result = pstmt.executeUpdate();
				
				
		 pstmt = connection
							.prepareStatement("select * from user ");
					
					ResultSet rs = pstmt.executeQuery();
					
				
					while(rs.next()) {
						
				
						id = rs.getInt("userId");
							
					}
					
			
				} 
		catch (SQLException e) { 
					e.printStackTrace();
				}
		
		System.out.println("in dao"+u.getRelativeId());
		
		if(u.getRelativeId()!=null) {
			 
			
			
			PreparedStatement pstmt = connection.
					  prepareStatement("UPDATE  user SET relationwith = ?  where userId=? ");
					  pstmt.setInt(1, id); 
					  pstmt.setString(2, u.getRelativeId());
					  pstmt.executeUpdate();
					 
		}
			
		/*
		 * if(u.getRelativeId()!=null) {
		 * 
		 * List<String> userList = new ArrayList<String>(); int relativeId =
		 * Integer.parseInt(u.getRelativeId());
		 * 
		 * String users = getId(relativeId); userList.add(users);
		 * userList.add(String.valueOf(id));
		 * 
		 * String usersList = String.join(",", userList);
		 * 
		 * PreparedStatement pstmt = connection.
		 * prepareStatement("UPDATE  user SET relationwith = ?  where userId=? ");
		 * pstmt.setString(1, usersList); pstmt.setString(2, u.getRelativeId());
		 * pstmt.executeUpdate();
		 * 
		 * }
		 */
		
		return id;
	}
	public List<User> getUserName() {
		
		
		List<User> list = new ArrayList<User>();
		User user ;
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from user where isAdmin=0 ");
			
			ResultSet rs = pstmt.executeQuery();
			
		
			while(rs.next()) {
				
				rs.getString("fname");
				
					user = new User();
					user.setUserFName(rs.getString("fname"));
					user.setUserId(rs.getInt("userId"));
					list.add(user);
			}
			
	
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		
		System.out.println("list" + list);
		
		return list;
	}

	public String getId(int userId) {
	
		
		String id = null;
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from user where userId=? ");
			
			pstmt.setInt(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			
		
			while(rs.next()) {
				
		
				id = rs.getString("relationWith");
					
			}
			
	
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return id;
	}

	public List<User> getData() {
		
		
		List<User> list = new ArrayList<User>();
		User user;
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from user where isAdmin=0");
			
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
			
	
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return list;
	
	}

	public int updatePass(User user) {
		
		
		int result = 0;
		
		try {
			PreparedStatement pstmt = connection.prepareStatement("UPDATE  user SET password=?  where email=? " );
			
			pstmt.setString(1, user.getUserPass());
			pstmt.setString(2, user.getUserEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

				
		return result;
	}

	public List<User> viewAdmin(User user) {
		
		
		
		List<User> list = new ArrayList<User>();
		
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from user where email=? ");
			
			pstmt.setString(1, user.getUserEmail());
			
			ResultSet rs = pstmt.executeQuery();
			
		
			while(rs.next()) {
				
			
					user = new User();
					
					user.setUserId(rs.getInt("userId"));
					user.setUserFName(rs.getString("fname"));
					user.setUserLName(rs.getString("lname"));
					user.setUserEmail(rs.getString("email"));
					user.setUserPass(rs.getString("password"));
					user.setUserGender(rs.getString("gender"));
					Blob blob = rs.getBlob("image");

					byte[] photo = blob.getBytes(1, (int) blob.length());
					String base64Image = Base64.getEncoder().encodeToString(photo);
					user.setBase64image(base64Image);
					user.setUserHobby(rs.getString("hobby"));
					user.setUserMobile(rs.getString("mobile"));
					user.setUserId(rs.getInt("userId"));
					
					list.add(user);
			
			}
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	
	}

	public int deleteRecord(int id) {
	
		int result=0;
		
		try {
			
			PreparedStatement pstmt = connection
					.prepareStatement("delete from user where userId=?");
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	

	public int deleteID(int relativeId, int userId) {
		
	
		int result=0;
		
		System.out.println("user id "+userId);
//		String users = getId(relativeId);
		String users = "";
		
	
		try {
			
			PreparedStatement pstmt = connection
					.prepareStatement("UPDATE  user SET relationWith=?  where userId=?");
			pstmt.setString(1, users);
			pstmt.setInt(2, relativeId);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return result;
	}

	public int update(User user) {
		// TODO Auto-generated method stub
		
		int result = 0;
		
		try {
			PreparedStatement pstmt = connection.prepareStatement("UPDATE  user SET fname=?,lname=?,gender=?,mobile=?, image=?  where email=? " );
			
			pstmt.setString(1, user.getUserFName());
			pstmt.setString(2, user.getUserLName());
			pstmt.setString(3, user.getUserGender());
			
			pstmt.setString(4, user.getUserMobile());
			pstmt.setBlob(5,user.getImage());
			pstmt.setString(6, user.getUserEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

				
		return result;

	
	}

	public boolean existRecord(int id) {
		// TODO Auto-generated method stub
		
		
			PreparedStatement pstmt;
			try {
				pstmt = connection
						.prepareStatement("select * from user where userId=? ");

				pstmt.setInt(1, id);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
				
					return true;
				}
				else {
					
					return false;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
					
		return false;
	}

	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		
		boolean returnval = false;
		PreparedStatement pstmt;
			try {
				pstmt=connection.prepareStatement("select email from user where email=?" );
	                   
				pstmt.setString(1, email);
				
				ResultSet rs=pstmt.executeQuery();
				
				if(rs.next()) {
					System.out.println("exist");
					returnval = true;
					
				}else {
					
					System.out.println("not exist");
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return returnval;
	}

	public List<User> getDetails(int id) {
		// TODO Auto-generated method stub
		
		List<User> list = new ArrayList<User>();
		User u = new User();
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from user where userId=?");
			pstmt.setInt(1, id);
			
			
			ResultSet rs = pstmt.executeQuery();
			
		
			if(rs.next()) {
				u.setUserId(rs.getInt("userId"));
				u.setUserFName(rs.getString("fname"));
				u.setUserLName(rs.getString("lname"));
				u.setUserGender(rs.getString("gender"));
				u.setUserHobby(rs.getString("hobby"));
				u.setUserMobile(rs.getString("mobile"));
				u.setUserEmail(rs.getString("email"));
				u.setUserPass(rs.getString("password"));
				Blob blob = rs.getBlob("image");

				byte[] photo = blob.getBytes(1, (int) blob.length());
				String base64Image = Base64.getEncoder().encodeToString(photo);
				u.setBase64image(base64Image);
				u.setAdmin(rs.getBoolean("isAdmin"));
				list.add(u);
		
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

		
	

}
