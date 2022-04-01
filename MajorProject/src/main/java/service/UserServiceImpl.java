package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class UserServiceImpl implements UserService{
	UserDao userDao = null;
	public UserServiceImpl() throws ClassNotFoundException, SQLException{
		
		userDao = new UserDaoImpl();
	}

	public boolean login(User u) {
	
		boolean res = userDao.login(u);
		return res;
	}

	public int register(User u) throws  SQLException {
		// TODO Auto-generated method stub
		
		int result =  userDao.register(u);
		return result;
	}

	public List<User> getUserName() {
		// TODO Auto-generated method stub
		
//		List<User>  list = new ArrayList<User>();
		
		 List<User> list = userDao.getUserName();
		
		return list;
	}

	public int getId() {
		// TODO Auto-generated method stub
		int id = userDao.getId();
		return id;
	}

	public List<User> getData() {
		// TODO Auto-generated method stub
		
		List<User> list = userDao.getData();
		
		return list;
	}

	public int updatePass(User user) {
		// TODO Auto-generated method stub
		int result = userDao.updatePass(user);
		return 0;
	}

	public List<User> viewAdmin(User user) {
		// TODO Auto-generated method stub
		
		List<User> list = userDao.viewAdmin(user);
		
		return list;
	}

}
