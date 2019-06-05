package it.contrader.model;

public class Robot {

	private int robot_id;
	private String robot_model;
	private String robot_username;
	private String robot_password;
	private String robot_owner_name;
	private String robot_owner_surname;
	
	public Robot(int robotId, String robotModel, String robotUsername, String robotPassword, String ownerName,
			String ownerSurname) {
		// TODO Auto-generated constructor stub
		this.robot_id = robotId;
		this.robot_model  = robotModel;
		this.robot_username = robotUsername;
		this.robot_password = robotPassword;
		this.robot_owner_name = ownerName;
		this.robot_owner_surname = ownerSurname;
	}
	
	public Robot() {
		// TODO Auto-generated constructor stub
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
	public String getRobot_username() {
		return robot_username;
	}
	public void setRobot_username(String robot_username) {
		this.robot_username = robot_username;
	}
	public String getRobot_password() {
		return robot_password;
	}
	public void setRobot_password(String robot_password) {
		this.robot_password = robot_password;
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
	
	@Override
	public String toString() {
		return this.getRobot_id() + "\t" + this.getRobot_model()+ "\t" + this.getRobot_username()+ "\t" +this.getRobot_password()+ "\t" +this.getRobot_owner_name()+ "\t" +this.getRobot_owner_surname();
	}
	
	public boolean equals(Robot robotCompare) {
		if (!this.getRobot_username().equals(robotCompare.getRobot_username())) {
			return false;
		}
		
		if (!this.getRobot_model().equals(robotCompare.getRobot_model())) {
			return false;
		}

		return true;

	}
}
