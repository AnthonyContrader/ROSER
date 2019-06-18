package it.contrader.dto;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensordataDTO {

	private Integer dataId;	
	
	private String robotModel;

	private String patientName;

	private String patientSurname;
	
	private int decibel;
	
	private int faceExpress;
	
	private int humidity;
	
	private String dataDate;

	@Autowired
	public SensordataDTO(String robotModel, int decibel, int faceExpress, int humidity, String dataDate, String patientName, String patientSurname) {
		this.robotModel = robotModel;
		
		this.decibel=decibel;
		this.faceExpress=faceExpress;
		this.humidity=humidity;
		this.dataDate=dataDate;
		this.patientName = patientName;
		this.patientSurname = patientSurname;
	}
	
}
