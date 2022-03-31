package service;

import java.sql.SQLException;
import java.util.List;

import dao.AddressDao;
import dao.AddressDaoImpl;
import dao.UserDaoImpl;
import model.Address;
import model.User;

public class AddressServiceImpl implements AddressService{
	
	AddressDao l = null;
	
	public AddressServiceImpl() {
		
		
		try {
			l = new AddressDaoImpl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addData(int id, Address a) throws SQLException {
		// TODO Auto-generated method stub
		
		int result = l.addData(id, a);
		return result;
	}


	public List<Address> getData(int id) {
		// TODO Auto-generated method stub
		
		List<Address> list = l.getData(id);
		return list;
	}

	public int updateData(int id, Address a) throws SQLException {
		// TODO Auto-generated method stub
		int result = l.update(id, a);
		return result;
	}

	public List<Address> getId() {
		// TODO Auto-generated method stub
		
		List<Address> list = l.getId();
		return list;
	}

	public int addAddress(int id, Address a) throws SQLException {
		// TODO Auto-generated method stub
		int result = l.addAddress(id, a);
		return result;
	}

}
