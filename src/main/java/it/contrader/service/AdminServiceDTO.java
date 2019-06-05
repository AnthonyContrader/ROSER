package it.contrader.service;

import java.util.List;

import it.contrader.converter.AdminConverter;
import it.contrader.converter.UsersConverter;
import it.contrader.dao.AdminDAO;
import it.contrader.dto.DoctorDTO;
import it.contrader.dto.UsersDTO;

public class AdminServiceDTO {

	private AdminDAO adminDAO;
	private AdminDAO doctorDAO;

	public AdminServiceDTO() {
		this.doctorDAO = new AdminDAO();
	}

	public List<DoctorDTO> getAllUser() {
		return AdminConverter.toDTO(this.doctorDAO.getAllDoctor());
	}
	
	public UsersDTO getAdminByUsernameAndPasword(String username, String password) {
		return UsersConverter.toDTO(this.adminDAO.login(username, password));
	}

	public boolean insertDoctor(DoctorDTO doctorDTO) {
		return this.doctorDAO.insertDoctor(AdminConverter.toEntity(doctorDTO));
	}
	
	public DoctorDTO readDoctor(int doctorId) {
		return AdminConverter.toDTO(this.doctorDAO.readDoctor(doctorId));
	}
	
	public boolean updateDoctor(DoctorDTO doctorDTO) {
		return this.doctorDAO.updateDoctor(AdminConverter.toEntity(doctorDTO));
	}
	
	public boolean deleteDoctor(int userId) {
		return this.doctorDAO.deleteDoctor(userId);
	}
	
	
}

