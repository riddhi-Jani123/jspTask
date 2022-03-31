package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class UserServiceImpl implements UserService{
	UserDao l = null;
	public UserServiceImpl() throws ClassNotFoundException, SQLException{
		
	l = new UserDaoImpl();
	}

	public boolean login(User u) {
	
		boolean res = l.login(u);
		return res;
	}

	public int register(User u) throws  SQLException {
		// TODO Auto-generated method stub
		
		int result =  l.register(u);
		return result;
	}

	public List<User> getUserName() {
		// TODO Auto-generated method stub
		
//		List<User>  list = new ArrayList<User>();
		
		 List<User> list = l.getUserName();
		
		return list;
	}

	public int getId() {
		// TODO Auto-generated method stub
		int id = l.getId();
		return id;
	}

	public List<User> getData() {
		// TODO Auto-generated method stub
		
		List<User> list = l.getData();
		
		return list;
	}

	public int updatePass(User user) {
		// TODO Auto-generated method stub
		int result = l.updatePass(user);
		return 0;
	}

	public List<User> viewAdmin(User user) {
		// TODO Auto-generated method stub
		
		List<User> list = l.viewAdmin(user);
		
		return list;
	}

}
