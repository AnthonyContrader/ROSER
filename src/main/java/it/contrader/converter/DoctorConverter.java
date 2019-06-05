package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.UsersDTO;
import it.contrader.model.Users;


public class DoctorConverter {
	
	public static Users toEntity(UsersDTO userDTO) {

		Users user = null;
		if (userDTO != null) {
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
	
	public static List<Users> toEntity(List<UsersDTO> userDTO) {
		
		List<Users> userList = new ArrayList<>();
		if (userDTO != null) {
			for(UsersDTO user: userDTO) {
				Users tempUser = new Users();
				tempUser = new Users();
				tempUser.setName(user.getName());
				tempUser.setSurname(user.getSurname());
				tempUser.setUserId(user.getUserId());
				tempUser.setUserName(user.getUserName());
				tempUser.setUserType(user.getUserType());
				tempUser.setPassword(user.getPassword());
				tempUser.setUserState(user.isUserState());
			}
		}
		return userList;
	}
	
	public static UsersDTO toDTO(Users user) {

		UsersDTO doctorDTO = null;
		if (user != null) {
			doctorDTO = new UsersDTO();
			
			doctorDTO.setName(user.getName());
			doctorDTO.setSurname(user.getSurname());
			doctorDTO.setUserId(user.getUserId());
			doctorDTO.setUserName(user.getUserName());
			doctorDTO.setUserType(user.getUserType());
			doctorDTO.setPassword(user.getPassword());
			doctorDTO.setUserState(user.isUserState());
		}
		return doctorDTO;
	}
	
	public static List<UsersDTO> toDTO(List<Users> users) {

		List<UsersDTO> userDTOList = new ArrayList<>();
		if(users != null) {
			for(Users user: users) {
				UsersDTO usersDTO = new UsersDTO();
				usersDTO.setUserId(user.getUserId());
				usersDTO.setUserName(user.getUserName());
				usersDTO.setUserType(user.getUserType());
				usersDTO.setName(user.getName());
				usersDTO.setSurname(user.getSurname());
				usersDTO.setPassword(user.getPassword());
				usersDTO.setUserState(user.isUserState());
				userDTOList.add(usersDTO);
			}
		}
		return userDTOList;
	}
}
