package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.RobotDTO;
import it.contrader.model.Robot;

@Component
public class RobotConverter extends AbstractConverter<Robot,RobotDTO> {

		@Override
		public Robot toEntity(RobotDTO robotDTO) {
			Robot robot = null;
			if (robotDTO != null) {
				robot = new Robot(robotDTO.getId(),robotDTO.getModel(),robotDTO.getOwnername(),robotDTO.getOwnersurname());			
			}
			return robot;
		}

		@Override
		public RobotDTO toDTO(Robot robot) {
			RobotDTO robotDTO = null;
			if (robot != null) {
				robotDTO = new RobotDTO(robot.getId(),robot.getModel(),robot.getOwnername(),robot.getOwnersurname());
				
			}
			return robotDTO;
		}
}
