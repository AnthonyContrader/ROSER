package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.DoctorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Doctor;
import it.contrader.model.User;

public class ConverterDoctor 
{
	public static UserDTO toDTO(User user)
	{
		UserDTO userDTO = null;
		if(user != null)
		{
			userDTO = new UserDTO();
			userDTO.setName(user.getName());
			userDTO.setSurname(user.getSurname());
			userDTO.setUserId(user.getUserId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setUserState(user.isUserState());
			
		}
		
		return userDTO;
	}
	
	
	public static User toEntity(UserDTO userDTO)
	{
		User user = null;
		if(userDTO != null)
		{
			user = new User();
			user.setName(userDTO.getName());
			user.setSurname(userDTO.getSurname());
			user.setUserId(userDTO.getUserId());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			user.setUserState(userDTO.isUserState());
			
		}
		
		return user;
	}
	
	public static List<UserDTO> toListDTO(List<User> list)
	{
		List<UserDTO> listUserDTO = new ArrayList<>();
		if(!list.isEmpty())
		{
			for(User user : list)
			{
				listUserDTO.add(ConverterDoctor.toDTO(user));
			}
		}
		
		return listUserDTO;
	}
	
	public static List<User> toListEntity(List<UserDTO> listUserDTO)
	{
		List<User> list = new ArrayList<>();
		if (!listUserDTO.isEmpty()) {
			for (UserDTO userDTO : listUserDTO) {
				list.add(ConverterDoctor.toEntity(userDTO));
			}
		}
		return list;
	}
	
	

}
