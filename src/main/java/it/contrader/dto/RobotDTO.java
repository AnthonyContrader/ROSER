package it.contrader.dto;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Model dell'entità User. Contiene l'enum che definisce gli usertype (salvati come interi
 * a partire da 0 sul db).
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see UserDTO
 */
@Data

@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")

public class RobotDTO {

	
	private long id;
	
	private String model;
	
	private String ownername;
	
	private String ownersurname;
	
	public RobotDTO(String model,String ownername,String ownersurname)
	{
		this.model = model;
		this.ownername = ownername;
		this.ownersurname = ownersurname;
	}
	
}