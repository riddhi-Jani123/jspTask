package dao;

import java.sql.SQLException;
import java.util.List;

import model.Address;
import model.User;

public interface AddressDao {
	
	public int addData(int id ,Address a ) throws SQLException;
	
	public List<Address> getData(int id);
	
	public int update(int id ,Address a ) throws SQLException;
	
	public List<Address> getId();
	
	public int addAddress(int id ,Address a ) throws SQLException;

}
