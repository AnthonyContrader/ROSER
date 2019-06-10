package it.contrader.converter;

import it.contrader.dto.RobotDTO;
import it.contrader.model.Robot;

public class RobotConverter {
	
	public static Robot toEntity(RobotDTO robotDTO) {
		//String robotOwnerName, String robotOwnerSurname
		Robot robot = null;
		if (robotDTO != null) {
			robot = new Robot(robotDTO.getRobotId(), robotDTO.getRobotName(), robotDTO.getRobotSurname(), robotDTO.getPassword(),robotDTO.getRobotModel(), robotDTO.getRobotOwnerName(), robotDTO.getRobotOwnerSurname());
			robot.setData(robotDTO.getData());
			robot.setHumidity(robotDTO.getHumidity());
			robot.setFaceexpress(robotDTO.getFaceexpress());
			robot.setDecibel(robotDTO.getDecibel());
			System.out.println("Converter: " +robot);
		}
		return robot;
	}

	public static RobotDTO toDTO(Robot robot) {
		RobotDTO robotDTO = null;
		if (robot != null) {
			robotDTO = new RobotDTO(robot.getRobotId(), robot.getRobotName(), robot.getRobotSurname(), robot.getPassword(),robot.getRobotModel(), robot.getRobotOwnerName(), robot.getRobotOwnerSurname());
			robotDTO.setData(robot.getData());
			robotDTO.setHumidity(robot.getHumidity());
			robotDTO.setFaceexpress(robot.getFaceexpress());
			robotDTO.setDecibel(robot.getDecibel());
		}
		return robotDTO;
	}
}
