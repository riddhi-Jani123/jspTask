package model;

public class Address {
	
	private  int addressId;
	private String removeId;
	private String addressIdd; 
	private  int userId;
	private int  length;
	private  String sAddress;
	private  String city;
	private  String state;
	private  String pincode;
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
	public void setsAddress(String sAddress2) {
		this.sAddress = sAddress2;
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
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getAddressIdd() {
		return addressIdd;
	}
	public void setAddressIdd(String addressIdd) {
		this.addressIdd = addressIdd;
	}
	public String getRemoveId() {
		return removeId;
	}
	public void setRemoveId(String removeId) {
		this.removeId = removeId;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", removeId=" + removeId + ", addressIdd=" + addressIdd + ", userId="
				+ userId + ", length=" + length + ", sAddress=" + sAddress + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", addressType=" + addressType + "]";
	}
	
	
	
	
	
	
	

}
