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
public class Sensordata {

	@Id
	@Column(name = "dataId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dataId;	

	@Column(name = "robotModel")
	@NotNull
	private String robotModel;

	@Column(name = "patientName")
	@NotNull
	private String patientName;

	@Column(name = "patientSurname")
	@NotNull
	private String patientSurname;
	
	@Column(name = "decibel")
	@NotNull
	private int decibel;
	
	@Column(name = "faceExpress")
	@NotNull
	private int faceExpress;
	
	@Column(name = "humidity")
	@NotNull
	private int humidity;
	
	@Column(name = "dataDate")
	@NotNull
	private String dataDate;

}
