package model;

import java.io.InputStream;

public class User {

	private int userId;
	private String userFName;
	private String userLName;
	private String userEmail;
	private String userPass;
	private String userCPass;
	private String userGender;
	private String userHobby;
	private String userMobile;
	private InputStream imageData;
	private boolean isAdmin;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFName() {
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserCPass() {
		return userCPass;
	}

	public void setUserCPass(String userCPass) {
		this.userCPass = userCPass;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserHobby() {
		return userHobby;
	}

	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public InputStream getImageData() {
		return imageData;
	}

	public void setImageData(InputStream img) {
		this.imageData = img;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFName=" + userFName + ", userLName=" + userLName + ", userEmail="
				+ userEmail + ", userPass=" + userPass + ", userCPass=" + userCPass + ", userGender=" + userGender
				+ ", userHobby=" + userHobby + ", userMobile=" + userMobile + ", isAdmin=" + isAdmin + "]";
	}

}
