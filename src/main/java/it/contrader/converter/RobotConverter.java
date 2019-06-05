package it.contrader.converter;

import it.contrader.dto.RobotDTO;
import it.contrader.model.Robot;

public class RobotConverter {

	public static Robot toEntity(RobotDTO robotDTO) {

		Robot robot = null;
		if (robotDTO != null) {
			robot = new Robot();
			robot.setRobot_model(robotDTO.getRobot_model());
			robot.setRobot_username(robotDTO.getRobot_username());
			robot.setRobot_password(robotDTO.getRobot_password());
			robot.setRobot_owner_name(robotDTO.getRobot_owner_name());
			robot.setRobot_owner_surname(robotDTO.getRobot_owner_surname());
		}
		return robot;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */
	public static RobotDTO toDTO(Robot robot) {

		RobotDTO robotDTO = null;
		if (robot != null) {
			robotDTO = new RobotDTO();
			//userDTO.setUserId(user.getUserId());
			//userDTO.setUsername(user.getUsername());
			//userDTO.setUsertype(user.getUsertype());
			
			robotDTO.setRobot_model(robot.getRobot_model());
			robotDTO.setRobot_username(robot.getRobot_username());
			robotDTO.setRobot_password(robot.getRobot_password());
			robotDTO.setRobot_owner_name(robot.getRobot_owner_name());
			robotDTO.setRobot_owner_surname(robot.getRobot_owner_surname());
		}
		return robotDTO;
	}
}
