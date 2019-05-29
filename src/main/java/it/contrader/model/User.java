package it.contrader.model;

public class User {
	private int userId;
	private String username;
	private String usertype;
	private String name;
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

	private String surname;
	private String password;
	private boolean userState;

	public User() {
	}

	public User( int userId , String username, String usertype , String name , String surname ,String password , boolean userState) {
		this.username = username;
		this.usertype = usertype;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	public void changeState() {
		this.userState = !this.userState;
	}

	@Override
	public String toString() {
		return this.getUserId() + "\t" + this.getUsername() + "\t" + this.getUsertype();
	}

	public boolean equals(User userCompare) {
		if (!this.getUsername().equals(userCompare.getUsername())) {
			return false;
		}

		if (!this.getUsertype().equals(userCompare.getUsertype())) {
			return false;
		}

		return true;

	}

}
