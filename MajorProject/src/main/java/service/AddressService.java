package service;

import java.sql.SQLException;
import java.util.List;

import model.Address;
import model.User;

public interface AddressService {
	
	public int addData(int id ,Address a ) throws SQLException;
	
	public List<Address> getData(int id);
	
	public int updateData(int id ,Address a ) throws SQLException; 
	
	public List<Address> getId();
	
	public int addAddress(int id ,Address a ) throws SQLException;

}
