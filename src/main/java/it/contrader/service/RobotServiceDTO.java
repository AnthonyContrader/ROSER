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
		return this.robotDAO.getAllRobot();
	}
	
	public RobotDTO getRobotByUsernameAndPasword(String username, String password) {
		return RobotConverter.toDTO(robotDAO.login(username, password));
	}

	public boolean insertRobot(RobotDTO robotDTO) {
		return this.robotDAO.insertRobot(RobotConverter.toEntity(robotDTO));
	}
	
	public RobotDTO readRobot(int robotId) {
		return RobotConverter.toDTO(this.robotDAO.readRobot(robotId));
	}
	
	public boolean updateRobot(RobotDTO robotDTO) {
		return this.robotDAO.updateRobot(RobotConverter.toEntity(robotDTO));
	}
	
	public boolean deleteRobot(int robotId) {
		return this.robotDAO.deleteRobot(robotId);
	}
	
}
