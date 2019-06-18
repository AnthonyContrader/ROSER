package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.RobotDTO;
import it.contrader.model.Robot;

public class ConverterRobot {

	public static RobotDTO toDTO(Robot robot) {
		RobotDTO robotDTO = null;
		if (robot != null) {
			robotDTO = new RobotDTO();
			robotDTO.setRobotId(robot.getRobotId());
			robotDTO.setRobotModel(robot.getRobotModel());
			robotDTO.setRobotOwnerName(robot.getRobotOwnerName());
			robotDTO.setRobotOwnerSurname(robot.getRobotOwnerSurname());
		}
		return robotDTO;
	}
	
	public static Robot toEntity(RobotDTO robotDTO) {
		Robot robot = null;
		if (robotDTO != null) {
			robot = new Robot();
			robot.setRobotId(robotDTO.getRobotId());
			robot.setRobotModel(robotDTO.getRobotModel());
			robot.setRobotOwnerName(robotDTO.getRobotOwnerName());
			robot.setRobotOwnerSurname(robotDTO.getRobotOwnerSurname());
		}
		return robot;
	}

	public static List<RobotDTO> toListDTO(List<Robot> list) {
		List<RobotDTO> listRobotDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Robot robot : list) {
				listRobotDTO.add(ConverterRobot.toDTO(robot));
			}
		}
		return listRobotDTO;
	}

	public static List<Robot> toListEntity(List<RobotDTO> listRobotDTO) {
		List<Robot> list = new ArrayList<>();
		if (!listRobotDTO.isEmpty()) {
			for (RobotDTO robotDTO : listRobotDTO) {
				list.add(ConverterRobot.toEntity(robotDTO));
			}
		}
		return list;
	}
}
