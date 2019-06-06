package it.contrader.dto;

public class RobotDTO {

	private int robot_id;
	
	private String robot_model;
	private String username;
	private String password;
	private String robot_owner_name;
	private String robot_owner_surname;
	private String name;
	private String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	private String surname;
	private boolean state;
	
	public RobotDTO() {}
	
	public RobotDTO(int robotId,String name,String surname,String username,String password,String type, boolean state)
	{
		this.robot_id = robotId;
		this.name=name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.type = type;
		this.state=state;
		
	}
	
	public int getRobot_id() {
		return robot_id;
	}

	public void setRobot_id(int robot_id) {
		this.robot_id = robot_id;
	}

	public String getRobot_model() {
		return robot_model;
	}

	public void setRobot_model(String robot_model) {
		this.robot_model = robot_model;
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

	public String getRobot_owner_name() {
		return robot_owner_name;
	}

	public void setRobot_owner_name(String robot_owner_name) {
		this.robot_owner_name = robot_owner_name;
	}

	public String getRobot_owner_surname() {
		return robot_owner_surname;
	}

	public void setRobot_owner_surname(String robot_owner_surname) {
		this.robot_owner_surname = robot_owner_surname;
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

	public RobotDTO(int robotId, String robotModel,String ownerName, String ownerSurname, String username, String password) {
		this.robot_id = robotId;
		this.robot_model  = robotModel;
		this.username = username;
		this.password = password;
		this.robot_owner_name = ownerName;
		this.robot_owner_surname = ownerSurname;
	}

	public int getRobotId() {
		return robot_id;
	}


	public void setRobotId(int robot_id) {
		this.robot_id = robot_id;
	}


	public String getRobotModel() {
		return robot_model;
	}


	public void setRobotModel(String robot_model) {
		this.robot_model = robot_model;
	}


	public String getRobotOwnerName() {
		return robot_owner_name;
	}


	public void setRobotOwnerName(String robot_owner_name) {
		this.robot_owner_name = robot_owner_name;
	}


	public String getRobotOwnerSurname() {
		return robot_owner_surname;
	}


	public void setRobotOwnerSurname(String robot_owner_surname) {
		this.robot_owner_surname = robot_owner_surname;
	}
	
	public String getRobotUsername() {
		return username;
	}

	public void setRobotUsername(String robot_username) {
		this.username = robot_username;
	}

	public String getRobotPassword() {
		return this.password;
	}

	public void setRobotPassword(String robot_password) {
		this.password = robot_password;
	}


	@Override
	public String toString()
	{
		return this.getRobotModel() + "\t" + this.getRobotOwnerName() +"\t" +this.getRobotOwnerSurname();
	}
	
}
