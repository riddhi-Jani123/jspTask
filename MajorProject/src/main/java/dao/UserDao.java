package dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import model.User;

public interface UserDao {

	public boolean login(User u);
	
	public int register(User u) throws SQLException;
	
	public List<User> getUserName() ;
	

}
