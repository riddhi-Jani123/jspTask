package dao;

import java.sql.SQLException;

import model.Address;
import model.User;

public interface AddressDao {
	
	public int addData(User u ,Address a ) throws SQLException;

}
