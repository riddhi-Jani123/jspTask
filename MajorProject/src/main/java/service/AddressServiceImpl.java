package service;

import java.sql.SQLException;

import dao.AddressDaoImpl;
import dao.UserDaoImpl;
import model.Address;
import model.User;

public class AddressServiceImpl implements AddressService{
	
	AddressDaoImpl l = null;
	
	public AddressServiceImpl() {
		
		
		try {
			l = new AddressDaoImpl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addData(User u, Address a) throws SQLException {
		// TODO Auto-generated method stub
		
		int result = l.addData(u, a);
		return result;
	}

}
