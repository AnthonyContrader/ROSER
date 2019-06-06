package it.contrader.model;

public class Robot {

	private int robotId;
	
	private String robotModel;
	public int getRobotId() {
		return robotId;
	}

	public void setRobotId(int robotId) {
		this.robotId = robotId;
	}

	public String getRobotModel() {
		return robotModel;
	}

	public void setRobotModel(String robotModel) {
		this.robotModel = robotModel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getRobotOwnerName() {
		return robotOwnerName;
	}

	public void setRobotOwnerName(String robotOwnerName) {
		this.robotOwnerName = robotOwnerName;
	}

	public String getRobotOwnerSurname() {
		return robotOwnerSurname;
	}

	public void setRobotOwnerSurname(String robotOwnerSurname) {
		this.robotOwnerSurname = robotOwnerSurname;
	}

	private String username;
	private String password;
	private String name;
	private String surname;
	private String type;
	private boolean state;
	private String robotOwnerName;
	private String robotOwnerSurname;
	
	public Robot() {}
	
	public Robot(int robotId,String name,String surname,String username,String password,String type,boolean state)
	{
		this.robotId = robotId;
		this.name=name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.type = type;
		this.state=state;
		
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Robot(int robotId, String robotModel,String ownerName, String ownerSurname, String username, String password) {
		this.robotId = robotId;
		this.robotModel  = robotModel;
		this.username = username;
		this.password = password;
		this.robotOwnerName = ownerName;
		this.robotOwnerSurname = ownerSurname;
	}

	public void setRobotPassword(String robot_password) {
		this.password = robot_password;
	}
}
