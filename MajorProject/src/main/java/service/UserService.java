package service;

import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import model.User;

public interface UserService {
	
	public boolean login(User u);
	public int register(User u) throws  SQLException;
	public List<User> getUserName();

	public int getId();
	
	public List<User> getData();
	
	public int updatePass(User user);
	
	public List<User> viewAdmin(User user);
}
