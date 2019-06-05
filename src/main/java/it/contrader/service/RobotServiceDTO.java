package it.contrader.service;

import java.util.List;

import it.contrader.converter.RobotConverter;
import it.contrader.dao.RobotDAO;
import it.contrader.dto.RobotDTO;

public class RobotServiceDTO {

	private RobotDAO robotDAO;

	public RobotServiceDTO() {
		this.robotDAO = new RobotDAO();
	}

	public List<RobotDTO> getAllRobot() {
		return null;
	}
	
	public RobotDTO getRobotByUsernameAndPasword(String username, String password) {
		return null;
	}

	public boolean insertRobot(RobotDTO robotDTO) {
		return false;
	}
	
	public RobotDTO readRobot(int robotId) {
		return null;
	}
	
	public boolean updateRobot(RobotDTO robotDTO) {
		return false;
	}
	
	public boolean deleteRobot(int robotId) {
		return false;
	}
	
}
