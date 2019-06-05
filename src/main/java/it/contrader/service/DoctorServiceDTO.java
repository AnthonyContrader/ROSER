package it.contrader.service;

import java.util.List;

import it.contrader.converter.DoctorConverter;
import it.contrader.dao.DoctorDAO;

import it.contrader.dto.DoctorDTO;

public class DoctorServiceDTO {


	private DoctorDAO doctorDAO;

	public DoctorServiceDTO() {
		this.doctorDAO = new DoctorDAO();
	}

	public List<DoctorDTO> getAllDoctor() {
		return this.doctorDAO.getAllDoctor();
	}
	
	public DoctorDTO getDoctorByUsernameAndPasword(String username, String password) {
		return DoctorConverter.toDTO(doctorDAO.login(username, password));
	}

	public boolean insertDoctor(DoctorDTO doctorDTO) {
		return this.doctorDAO.insertDoctor(DoctorConverter.toEntity(doctorDTO));
	}
	
	public DoctorDTO readDoctor(int doctorId) {
		return DoctorConverter.toDTO(this.doctorDAO.readDoctor(doctorId));
	}
	
	public boolean updateDoctor(DoctorDTO doctorDTO) {
		return this.doctorDAO.updateDoctor(DoctorConverter.toEntity(doctorDTO));
	}
	
	public boolean deleteDoctor(int doctorId) {
		return this.doctorDAO.deleteDoctor(doctorId);
	}
	
}
