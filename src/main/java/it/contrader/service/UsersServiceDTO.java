package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.UsersConverter;
import it.contrader.dao.UsersDAO;
import it.contrader.dto.UsersDTO;
import it.contrader.model.Users;

public class UsersServiceDTO {

	private final UsersDAO usersDAO;

	public UsersServiceDTO() {
		this.usersDAO = new UsersDAO();
	}
	
	public List<UsersDTO> getAllUsers() {
		
		List<Users> list = usersDAO.getAllUsers();
		List<UsersDTO> listDTO = new ArrayList<>();

		for (Users users : list) {
			listDTO.add(UsersConverter.toDTO(users));
		}

		return listDTO;
	}
	
	public UsersDTO getUserByUsernameAndPasword(String username, String password) {
		return UsersConverter.toDTO(usersDAO.login(username, password));
	}
	
	public boolean updateUsers (UsersDTO usersDTO) {
		return this.usersDAO.updateUsers(UsersConverter.toEntity(usersDTO));
		
}
	
	public boolean deleteUsers (UsersDTO usersDTO) {
		return this.usersDAO.deleteUsers(UsersConverter.toEntity(usersDTO));
		
}
	
	public boolean insertUsers (UsersDTO usersDTO) {
		return this.usersDAO.insertUsers(UsersConverter.toEntity(usersDTO));
	
}
		
	
	
}
