package it.contrader.model;

public class Robot {

	private int robot_id;
	
	private String robot_model;
	private String robot_username;
	private String robot_password;
	private String robot_owner_name;
	private String robot_owner_surname;
	
	public Robot() {}
	
	public Robot(int robotId, String robotModel,String ownerName, String ownerSurname, String username, String password) {
		this.robot_id = robotId;
		this.robot_model  = robotModel;
		this.robot_username = username;
		this.robot_password = password;
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


	public String getRoborOwnerSurname() {
		return robot_owner_surname;
	}


	public void setRobotOwnerSurname(String robot_owner_surname) {
		this.robot_owner_surname = robot_owner_surname;
	}
	
	public String getRobotUsername() {
		return robot_username;
	}

	public void setRobotUsername(String robot_username) {
		this.robot_username = robot_username;
	}

	public String getRobotPassword() {
		return robot_password;
	}

	public void setRobotPassword(String robot_password) {
		this.robot_password = robot_password;
	}


	@Override
	public String toString()
	{
		return this.getRobotModel() + "\t" + this.getRobotOwnerName() +"\t" +this.getRoborOwnerSurname();
	}
	
}
