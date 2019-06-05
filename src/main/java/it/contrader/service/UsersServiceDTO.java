package it.contrader.service;

import it.contrader.converter.UsersConverter;
import it.contrader.dao.UsersDAO;
import it.contrader.dto.UsersDTO;

public class UsersServiceDTO {
	private UsersDAO userDAO;
	
	public UsersServiceDTO() {
		this.userDAO = new UsersDAO();
	}
	
	public UsersDTO getUsersByUserNameAndPassword(String userName, String password) {
		return UsersConverter.toDTO(this.userDAO.login(userName, password));
	}
}
