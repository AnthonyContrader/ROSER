package it.contrader.dto;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RobotDTO {

	private Integer robotId;	
	
	private String robotModel;

	private String robotOwnerName;

	private String robotOwnerSurname;

	@Autowired
	public RobotDTO(String robotModel, String robotOwnerName, String robotOwnerSurname) {
		this.robotModel = robotModel;
		this.robotOwnerName = robotOwnerName;
		this.robotOwnerSurname = robotOwnerSurname;
	}
	
}
