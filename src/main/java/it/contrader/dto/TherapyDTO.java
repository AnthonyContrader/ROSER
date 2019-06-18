package it.contrader.dto;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TherapyDTO {

	private Integer therapyId;	
	
	private String medicinesType;
	
	private String medicinesName;
	
	private int medicinesNumber;
	
	private String startDate;
	
	private String endDate;

	@Autowired
	public TherapyDTO(String medicinesType, String medicinesName, int medicinesNumber, String startDate, String endDate) {
		this.medicinesType = medicinesType;
		this.medicinesName = medicinesName;
		this.medicinesNumber = medicinesNumber;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
}

