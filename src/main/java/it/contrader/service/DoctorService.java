package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterUser;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

public class DoctorService {
	
	private UserDAO doctorDAO;
	
	public DoctorService() {
		this.doctorDAO = new UserDAO();
	}
	
	public List<User> getAllUser() {
		return this.doctorDAO.getAllUser();
	}
	
	public boolean insertUser(UserDTO userDTO) {
		return this.doctorDAO.insertUser(ConverterUser.toEntity(userDTO));
	}
	
	public UserDTO readUser(int userId) {
		return ConverterUser.toDTO(this.doctorDAO.readUser(userId));
	}
	
	public boolean updateUser(UserDTO userDTO) {
		return this.doctorDAO.updateUser(ConverterUser.toEntity(userDTO));
	}
	
	public boolean deleteUser(int userId) {
		return this.doctorDAO.deleteUser(userId);
	}
}
