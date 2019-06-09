package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.UsersConverter;
import it.contrader.dao.UsersDAO;
import it.contrader.dto.UsersDTO;
import it.contrader.model.Users;

public class UsersService {

	private final UsersDAO usersDAO;

	public UsersService() {
		this.usersDAO = new UsersDAO();
	}
	
	//Tutti i metodi presenti sotto richiamano i metodi del DAO
	//E' neccessario usare i service dato che sono il livello più alto e non si può accedere direttamente al dao
	//e utilizzerano oggetti DTO che verrano convertiti con le classi Converter che restituira degli oggi del package Model
	//che verrano poi usati come parametri nei metodi del DAO
	
	public UsersDTO getUserByUsernameAndPasword(String username, String password) {
		return UsersConverter.toDTO(usersDAO.login(username, password));
	}
	
	public List<UsersDTO> getAllUsers() {
		List<Users> usersList = usersDAO.getAllUsers(); //Preleviamo dal DAO la lista degli utenti che ha come ritorno List<Users>
		List<UsersDTO> listDTO = new ArrayList<>();     //Creiamo una lista di tipo List<UsersDTO> dato che ai livelli
		                                                //superiori si opera con gli oggetti DTO
		
		//Popoliamo la lista List<UsersDTO> usando la lista List<Users>
		for(Users user: usersList) {
			listDTO.add(UsersConverter.toDTO(user));
		}

		return listDTO;
	}

	public boolean updateUsers(UsersDTO usersDTO) {
		return this.usersDAO.updateUsers(UsersConverter.toEntity(usersDTO));
	}
	
	public boolean deleteUsers (UsersDTO usersDTO) {
		return this.usersDAO.deleteUsers(UsersConverter.toEntity(usersDTO));
	}
	
	public boolean insertUsers (UsersDTO usersDTO) {
		return this.usersDAO.insertUsers(UsersConverter.toEntity(usersDTO));
	}
	
	public UsersDTO readUser(int userId) {
		return UsersConverter.toDTO(this.usersDAO.readUsers(UsersConverter.toEntity(new UsersDTO(userId))));
	}
}
