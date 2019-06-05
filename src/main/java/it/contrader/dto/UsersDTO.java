package it.contrader.dto;

public class UsersDTO {
	private int userId;
	private String username;
	private String usertype;
	private String name;
	private String surname;
	private String password;
	private boolean userState;
	
	public UsersDTO() {}
	
	public UsersDTO(int userId, String name, String surname, String userName, String password,String userType, boolean userState) {
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.username = userName;
		this.password = password;
		this.usertype = userType;
		this.userState = userState;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getUserType() {
		return usertype;
	}

	public void setUserType(String usertype) {
		this.usertype = usertype;
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
	
	@Override
	public String toString()
	{
		return this.getUserId() +"\t"+ this.getName() + "\t" + this.getSurname() + "\t" + this.getUserName() + "\t" + this.getPassword() + "\t"+ this.isUserState();
	}
}
