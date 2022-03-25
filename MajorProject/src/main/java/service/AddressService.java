package service;

import java.sql.SQLException;

import model.Address;
import model.User;

public interface AddressService {
	
	public int addData(User u ,Address a ) throws SQLException;

}
