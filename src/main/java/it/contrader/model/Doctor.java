package it.contrader.model;

public class Doctor {
	private int userId;
	private String username;
	private String usertype;
	private String name;
	private String surname;
	private String password;
	private boolean userState;
	
	public Doctor( int userId , String username, String name , String surname ,String password , boolean userState) {
		this.username = username;
		this.usertype = "doctor";
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.userId = userId;
		this.userState = userState;
	}

	public Doctor(){}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsertype() {
		return usertype;
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
