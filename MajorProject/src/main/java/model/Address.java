package model;

public class Address {
	
	private  int addressId;
	private  int userId;
	private  String sAddress;
	private  String city;
	private  String state;
	private  int pincode;
	private String addressType;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", userId=" + userId + ", sAddress=" + sAddress + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + ", addressType=" + addressType + "]";
	}
	
	
	
	

}
