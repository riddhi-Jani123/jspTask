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

	public String getId(int id) {
		// TODO Auto-generated method stub
		String Id = userDao.getId(id);
		return Id;
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

	public int deleteRecord(int id) {
		// TODO Auto-generated method stub
		
		int result = userDao.deleteRecord(id);
		return result;
	}

	public int deleteID(int relativeId , int userId ) {
		// TODO Auto-generated method stub
		
			
			int result  = userDao.deleteID(relativeId, userId);
			return result;
		

	}

	public int update(User u){
		// TODO Auto-generat,ed method stub
		
		int result = userDao.update(u);
		return result;
	}

	public boolean existRecord(int id) {
		// TODO Auto-generated method stub
		
		boolean isExist =  userDao.existRecord(id);
		
		return isExist;
	}
	public boolean checkEmail(String Email) {
		// TODO Auto-generated method stub
		
		boolean isExist = userDao.checkEmail(Email);
		return isExist;
	}

	public List<User> getDetails(int id) {
		// TODO Auto-generated method stub
		List<User> userList = userDao.getDetails(id);
		return userList;
	}

	

}
