package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.UsersDTO;
import it.contrader.model.Users;

public class UsersConverter {

	public static Users toEntity(UsersDTO usersDTO) {

		Users users = null;
		if (usersDTO != null) {
			users = new Users(usersDTO.getUserId(), usersDTO.getUserName(), usersDTO.getUserType(), usersDTO.getName(), usersDTO.getSurname(), usersDTO.getPassword(), usersDTO.isUserState());
		}

		return users;
	}
	
	public static UsersDTO toDTO(Users users) {

		UsersDTO usersDTO = null;
		if (users != null) {
			usersDTO = new UsersDTO(users.getUserId(), users.getUserName(), users.getUserType(), users.getName(), users.getSurname(), users.getPassword(), users.isUserState());
		}

		return usersDTO;
	}
	

}
