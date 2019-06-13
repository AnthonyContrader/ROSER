package it.contrader.dto;

import org.springframework.beans.factory.annotation.Autowired;

import it.contrader.model.Sensordata;
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
	
	private String robotName;
	
	private String robotSurname;
	
	private String password;
	
	private Sensordata sensorData;

	@Autowired
	public RobotDTO(String robotModel, String robotOwnerName, String robotOwnerSurname, String robotName, String robotSurname, String password) {
		this.robotModel = robotModel;
		this.robotOwnerName = robotOwnerName;
		this.robotOwnerSurname = robotOwnerSurname;
	}
	
}



