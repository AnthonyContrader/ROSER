package it.contrader.dto;

public class DoctorDTO {
	private int userId;
	
	private String username;
	private String usertype;
	private String name;
	private String surname;
	private String password;
	private boolean userState;
	
	public DoctorDTO(String name,String surname,String username,String password,boolean userState){
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.usertype = "doctor";
		this.userState = userState;
	}
	
	public DoctorDTO() {} 
	

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
	
	@Override
	public String toString()
	{
		return this.getName() + "\t" + this.getSurname() + "\t" + this.getUsername() + "\t" + this.getPassword();
	}
}
