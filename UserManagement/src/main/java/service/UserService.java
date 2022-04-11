package service;

import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import model.Address;
import model.User;

public interface UserService {
	
	public boolean login(User u);
	public int register(User u) throws  SQLException;
	public List<User> getUserName();

	public String getId(int id);
	
	public List<User> getData();
	
	public int updatePass(User user);
	
	public List<User> viewAdmin(User user);
	
	public int deleteRecord(int id);
	
	public int deleteID(int relativeId , int userId);
	public int update(User u);

	public boolean existRecord(int id);
	public boolean checkEmail(String Email);
	
	public List<User> getDetails(int id);
	
}
