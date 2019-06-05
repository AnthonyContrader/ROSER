package it.contrader.service;

import java.util.List;

import it.contrader.converter.DoctorConverter;
import it.contrader.dao.DoctorDAO;
import it.contrader.dto.UsersDTO;
import it.contrader.model.Robot;
import it.contrader.model.Users;

public class DoctorServiceDTO {


	private DoctorDAO doctorDAO;

	public DoctorServiceDTO() {
		this.doctorDAO = new DoctorDAO();
	}

	public List<UsersDTO> getAllPatient() {
		return DoctorConverter.toDTO(this.doctorDAO.getAllPatient());
	}
	
	public UsersDTO getDoctorByUsernameAndPasword(String username, String password) {
		return DoctorConverter.toDTO(doctorDAO.login(username, password));
	}

	public boolean insertPatient(UsersDTO userDTO) {
		return this.doctorDAO.insertPatient(DoctorConverter.toEntity(userDTO));
	}
	
	public UsersDTO readPatient(int patientId) {
		return DoctorConverter.toDTO(this.doctorDAO.readPatient(patientId));
	}
	
	public boolean updateDoctor(UsersDTO patientDTO) {
		return this.doctorDAO.updatePatient(DoctorConverter.toEntity(patientDTO));
	}
	
	public boolean deletePatient(int patientId) {
		return this.doctorDAO.deletePatient(patientId);
	}
	
	public boolean matchRobot(Users user, Robot robot) {
		return this.doctorDAO.matchRobot(user, robot);
	}
	
	public boolean disMatchRobot(Robot robot) {
		return this.doctorDAO.disMatchRobot(robot);
	}
	
}
