package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Therapy {

	@Id
	@Column(name = "therapyId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer therapyId;	
	
	@Column(name = "medicinesType")
	@NotNull
	private String medicinesType;

	@Column(name = "medicinesName")
	@NotNull
	private String medicinesName;
	
	@Column(name = "medicinesNumber")
	@NotNull
	private int medicinesNumber;
	
	@Column(name = "startDate")
	@NotNull
	private String startDate;
	
	@Column(name = "endDate")
	@NotNull
	private String endDate;

/*	@Column(name = "robotOwnerSurname")
	@NotNull
	private String robotOwnerSurname;
*/
}


