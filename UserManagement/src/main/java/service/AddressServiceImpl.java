package service;

import java.sql.SQLException;
import java.util.List;

import dao.AddressDao;
import dao.AddressDaoImpl;
import dao.UserDaoImpl;
import model.Address;
import model.User;

public class AddressServiceImpl implements AddressService{
	
	AddressDao addressDao = null;
	
	public AddressServiceImpl() {
		
		
		try {
			addressDao = new AddressDaoImpl();
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
		
		int result = addressDao.addData(id, a);
		return result;
	}


	public List<Address> getData(int id) {
		// TODO Auto-generated method stub
		
		List<Address> list = addressDao.getData(id);
		return list;
	}

	public int updateData(int id, Address a) throws SQLException {
		// TODO Auto-generated method stub
		int result = addressDao.update(id, a);
		return result;
	}

	public List<Address> getId() {
		// TODO Auto-generated method stub
		
		List<Address> list = addressDao.getId();
		return list;
	}

	public int addAddress(int id, Address a) throws SQLException {
		// TODO Auto-generated method stub
		int result = addressDao.addAddress(id, a);
		return result;
	}

	public int deleteAddress(int id) {
		// TODO Auto-generated method stub
		
		int result = addressDao.deleteAddress(id);
		return result;
	}


	public String getRelativeId(int id) {
		// TODO Auto-generated method stub
		String result = addressDao.getRelativeId(id);
		return result;
	}

	public int updateAddress(int id, Address a) throws SQLException {
		// TODO Auto-generated method stub
		int result = addressDao.updateAddress(id, a);
		return result;
	}

	public List<Address> getHomeAddress(int id) {
		// TODO Auto-generated method stub
		List<Address> list = addressDao.getHomeAddress(id);
		return list;
	}

	public List<Address> getAdminAddress(int id) {
		// TODO Auto-generated method stub
		List<Address> list = addressDao.getHomeAddress(id);
		return list;
	}

	public List<Address> getAddress(Address a, int id) {
		// TODO Auto-generated method stub
		
		List<Address> list = addressDao.getAddress(a,id);
		return list;
	}

	public int updateUser(int addressId, int relativeId) {
		// TODO Auto-generated method stub
		
		int result =  addressDao.updateUser(addressId, relativeId);
		
		return result;
	}

	public int deleteAdd(int id) {
		// TODO Auto-generated method stub
		
		int result = addressDao.deleteAdd(id);
		return result;
	}


}
