package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DoctorDTO;
import it.contrader.dto.UsersDTO;
import it.contrader.model.Doctor;
import it.contrader.model.Users;

public class UsersConverter {
	
	public static Users toEntity(UsersDTO userDTO) {
		Users user = null;
		if(userDTO !=null) {
			user = new Users();
			user.setName(userDTO.getName());
			user.setSurname(userDTO.getSurname());
			user.setUserId(userDTO.getUserId());
			user.setUserName(userDTO.getUserName());
			user.setUserType(userDTO.getUserType());
			user.setPassword(userDTO.getPassword());
			user.setUserState(userDTO.isUserState());
		}
		return user;
	}
	
	public static List<Users> toEntity(List<UsersDTO> usersDTO){
		List<Users> usersList = new ArrayList<>();
		if(usersDTO != null) {
			for(UsersDTO user: usersDTO) {
				Users userDoctor = new Users();
				userDoctor.setUserId(user.getUserId());
				userDoctor.setUserName(user.getUserName());
				userDoctor.setUserType(user.getUserType());
				userDoctor.setName(user.getName());
				userDoctor.setSurname(user.getSurname());
				userDoctor.setPassword(user.getPassword());
				userDoctor.setUserState(user.isUserState());
				usersList.add(userDoctor);
			}	
		}
		return usersList;
	}
	
	public static UsersDTO toDTO(Users user) {

		UsersDTO userDTO = new UsersDTO();
		if(user != null) {
			userDTO.setUserId(user.getUserId());
			userDTO.setUserName(user.getUserName());
			userDTO.setUserType(user.getUserType());
			userDTO.setName(user.getName());
			userDTO.setSurname(user.getSurname());
			userDTO.setPassword(user.getPassword());
			userDTO.setUserState(user.isUserState());
		}
		return userDTO;
	}
	
	public static List<UsersDTO> toDTO(List<Users> user) {

		List<UsersDTO> userDTOList = new ArrayList<>();
		if(user != null) {
			for(Users users: user) {
				UsersDTO userDTO = new UsersDTO();
				userDTO.setUserId(users.getUserId());
				userDTO.setUserName(users.getUserName());
				userDTO.setUserType(users.getUserType());
				userDTO.setName(users.getName());
				userDTO.setSurname(users.getSurname());
				userDTO.setPassword(users.getPassword());
				userDTO.setUserState(users.isUserState());
				userDTOList.add(userDTO);
			}
		}
		return userDTOList;
	}
}
