package it.contrader.model;

public class Users {
	private int userId;
	private String userName;
	private String userType;
	private String name;
	private String surname;
	private String password;
	private boolean userState;
	
	public Users() {}
	
	public Users(int userId, String userName, String userType, String name, String surname, String password, boolean userState) {
		this.userName = userName;
		this.userType = userType;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.userState = userState;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isUserState() {
		return userState;
	}

	public void setUserState(boolean userState) {
		this.userState = userState;
	}
}
