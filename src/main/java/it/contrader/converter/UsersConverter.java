package it.contrader.converter;

import it.contrader.dto.UsersDTO;
import it.contrader.model.Users;

public class UsersConverter {

	public static Users toEntity(UsersDTO usersDTO) {
		Users users = null;
		if (usersDTO != null) {
			users = new Users(usersDTO.getUserId(), usersDTO.getUserName(), usersDTO.getUserSurname(), usersDTO.getUserUser(),
					usersDTO.getUserPassword(), usersDTO.getUserType(), usersDTO.isUserState());
		}
		return users;
	}

	public static UsersDTO toDTO(Users users) {
		UsersDTO usersDTO = null;
		if (users != null) {
			usersDTO = new UsersDTO(users.getUserId(), users.getUserName(), users.getUserSurname(), users.getUserUser(),
					users.getUserPassword(), users.getUserType(), users.isUserState());
		}
		return usersDTO;
	}
}
