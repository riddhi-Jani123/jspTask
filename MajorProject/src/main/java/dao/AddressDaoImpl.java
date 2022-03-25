package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Address;
import model.User;
import utility.DatabaseConnection;

public class AddressDaoImpl implements AddressDao {
	
	Connection conn =null;
	public AddressDaoImpl() throws ClassNotFoundException, SQLException{
		
		conn = DatabaseConnection.getInstance().getConnection();
	}

	public int addData(User u, Address a) throws SQLException {
		// TODO Auto-generated method stub
		
		int result =0;
		PreparedStatement pstmt = conn
				.prepareStatement("INSERT INTO address (addressId, address, city, state, pincode,addressType)\n"
						+ "VALUES ((select userId from user where userId = ?))");
		
		
	
			try {
				pstmt.setInt(1, a.getAddressId());
				pstmt.setString(2,a.getsAddress());
				pstmt.setString(3, a.getCity());
				pstmt.setString(3, a.getState());
				pstmt.setString(4, String.valueOf(a.getPincode()));
				pstmt.setString(5, a.getAddressType());
				pstmt.setInt(6, u.getUserId());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	
		return result;
	}
	
	

}
