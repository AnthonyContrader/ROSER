package it.contrader.converter;

import it.contrader.dto.RobotDTO;
import it.contrader.model.Robot;

public class RobotConverter {
	
	public static Robot toEntity(RobotDTO robotDTO) {
		//String robotOwnerName, String robotOwnerSurname
		Robot robot = null;
		if (robotDTO != null) {
			robot = new Robot(robotDTO.getRobotId(), robotDTO.getRobotName(), robotDTO.getRobotSurname(), robotDTO.getPassword(),robotDTO.getRobotModel(), robotDTO.getRobotOwnerName(), robotDTO.getRobotOwnerName());
		}
		return robot;
	}

	public static RobotDTO toDTO(Robot robot) {
		RobotDTO robotDTO = null;
		if (robot != null) {
			robotDTO = new RobotDTO(robot.getRobotId(), robot.getRobotName(), robot.getRobotSurname(), robot.getPassword(),robot.getRobotModel(), robot.getRobotOwnerName(), robot.getRobotOwnerName());
		}
		return robotDTO;
	}
}
