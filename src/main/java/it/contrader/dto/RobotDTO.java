package it.contrader.dto;

public class RobotDTO {
	private int robotId;
	private String robotModel;
	private String robotOwnerName;
	private String robotOwnerSurname;
	private String robotName;
	private String robotSurname;
	private String password;
	/*private int decibel;
	private int faceexpress;
	private int humidity;*/
	
	public RobotDTO() {}
	
	public RobotDTO(String robotName, String robotSurname, String password, String robotModel, String robotOwnerName, String robotOwnerSurname) {
		this.robotName = robotName;
		this.robotSurname = robotSurname;
		this.password = password;
		this.robotModel = robotModel;
		this.robotOwnerName = robotOwnerName;
		this.robotOwnerSurname = robotOwnerSurname;
	}
	
	public RobotDTO(Integer robotId, String robotName, String robotSurname, String password, String robotModel, String robotOwnerName, String robotOwnerSurname) {
		this.robotName = robotName;
		this.robotSurname = robotSurname;
		this.password = password;
		this.robotId = robotId;
		this.robotModel = robotModel;
		this.robotOwnerName = robotOwnerName;
		this.robotOwnerSurname = robotOwnerSurname;
	}
	
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

	public String getRobotName() {
		return robotName;
	}

	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}

	public String getRobotSurname() {
		return robotSurname;
	}

	public void setRobotSurname(String robotSurname) {
		this.robotSurname = robotSurname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/*public int getDecibel() {
		return decibel;
	}
	public void setDecibel(int decibel) {
		this.decibel = decibel;
	}
	public int getFaceexpress() {
		return faceexpress;
	}
	public void setFaceexpress(int faceexpress) {
		this.faceexpress = faceexpress;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}*/
}
