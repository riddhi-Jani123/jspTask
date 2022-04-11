package service;

import java.sql.SQLException;
import java.util.List;

import model.Address;
import model.User;

public interface AddressService {
	
	public int addData(int id ,Address a ) throws SQLException;
	
	public List<Address> getData(int id);
	
	public List<Address> getHomeAddress(int id);
	
	public List<Address> getAdminAddress(int id);
	
	public int updateData(int id ,Address a ) throws SQLException; 
	
	public List<Address> getId();
	
	public int addAddress(int id ,Address a ) throws SQLException;
	
	public int deleteAddress(int id);
	
	public int deleteAdd(int id);
	
	public List<Address> getAddress(Address a , int id);

	public String getRelativeId(int id) ;
	
	public int updateAddress(int id, Address a) throws SQLException ;
	
	public int updateUser(int addressId, int relativeId);
	

}
