package it.contrader.dto;

public class UsersDTO {
	private Integer userId;
	private String userName;
	private String userSurname;
	private String userUser;
	private String userPassword;
	private String userType;
	private boolean userState;
	
	public UsersDTO(Integer userId) {
		setUserId(userId);
	}
	
	public UsersDTO(String userName, String userSurname, String userUser, String userPassword, String userType, boolean userState) {
		setUserName(userName);
		setUserSurname(userSurname);
		setUserUser(userUser);
		setUserPassword(userPassword);
		setUserType(userType);
		setUserState(userState);
	}
	
	public UsersDTO(Integer userId,String userName, String userSurname, String userUser, String userPassword, String userType,
			boolean userState) {
		setUserId(userId);
		setUserName(userName);
		setUserSurname(userSurname);
		setUserUser(userUser);
		setUserPassword(userPassword);
		setUserType(userType);
		setUserState(userState);
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getUserUser() {
		return userUser;
	}

	public void setUserUser(String userUser) {
		this.userUser = userUser;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isUserState() {
		return userState;
	}

	public void setUserState(boolean userState) {
		this.userState = userState;
	}
}