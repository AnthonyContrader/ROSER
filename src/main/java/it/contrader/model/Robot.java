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
public class Robot {

	@Id
	@Column(name = "robotId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer robotId;	

	@Column(name = "robotModel")
	@NotNull
	private String robotModel;

	@Column(name = "robotOwnerName")
	@NotNull
	private String robotOwnerName;

	@Column(name = "robotOwnerSurname")
	@NotNull
	private String robotOwnerSurname;

}

