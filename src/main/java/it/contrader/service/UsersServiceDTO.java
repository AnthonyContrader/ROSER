package it.contrader.service;

import java.util.List;

import it.contrader.converter.UsersConverter;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

public class UsersServiceDTO {

	private UserDAO userDAO;

	public UsersServiceDTO() {
		this.userDAO = new UserDAO();
	}

	public List<UserDTO> getAllUser() {
		return this.userDAO.getAllUser();
	}
	
	public UserDTO getUserByUsernameAndPasword(String username, String password) {
		return UsersConverter.toDTO(userDAO.login(username, password));
	}

	public boolean insertUser(UserDTO userDTO) {
		return this.userDAO.insertUser(UsersConverter.toEntity(userDTO));
	}
	
	public UserDTO readUser(int userId) {
		return UsersConverter.toDTO(this.userDAO.readUser(userId));
	}
	
	public boolean updateUser(UserDTO userDTO) {
		return this.userDAO.updateUser(UsersConverter.toEntity(userDTO));
	}
	
	public boolean deleteUser(int userId) {
		return this.userDAO.deleteUser(userId);
	}
	
	
}

