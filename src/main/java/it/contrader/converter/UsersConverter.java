package it.contrader.converter;


import it.contrader.dto.UserDTO;
import it.contrader.model.User;


/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class UsersConverter {


	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static User toEntity(UserDTO userDTO) {

		User user = null;
		if (userDTO != null) {
			user = new User();
			user.setName(userDTO.getName());
			user.setSurname(userDTO.getSurname());
			user.setUserId(userDTO.getUserId());
			user.setUsername(userDTO.getUsername());
			user.setUsertype(userDTO.getUsertype());
			user.setPassword(userDTO.getPassword());
			user.setUserState(userDTO.isUserState());
		}
		return user;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */
	public static UserDTO toDTO(User user) {

		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO();
			//userDTO.setUserId(user.getUserId());
			//userDTO.setUsername(user.getUsername());
			//userDTO.setUsertype(user.getUsertype());
			
			userDTO.setName(user.getName());
			userDTO.setSurname(user.getSurname());
			userDTO.setUserId(user.getUserId());
			userDTO.setUsername(user.getUsername());
			userDTO.setUsertype(user.getUsertype()); //da togliere
			userDTO.setPassword(user.getPassword());
			userDTO.setUserState(user.isUserState());
		}
		return userDTO;
	}
	

}
