package it.contrader.dto;

public class UserDTO {
	private int userId;
	
	private String username;
	private String usertype;
	private String name;
	private String surname;
	private String password;
	private boolean userState;
	
	public UserDTO(String name,String surname,String username,String password,String usertype,boolean userState)
	{
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.userState = userState;
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

	public UserDTO(String username, String usertype) {
		this.username = username;
		this.usertype = usertype;
	}
	
	public UserDTO() {} 
	
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

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	public void ShowAttributes()
	{
		System.out.println("nome:" + this.name + " " +"Cognome: "+ this.surname +" "+ "username: "+ this.username + " "+"password: "+this.password+ " " );
	}

}
