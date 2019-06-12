package it.contrader.dto;

import org.springframework.beans.factory.annotation.Autowired;

import it.contrader.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Integer userId;	
	
	private String userName;

	private String userPass;

	private String userUser;
	
	private String userType;
	
	private String userSurname;
	
	private boolean userState;

	@Autowired
	public UserDTO(String userName, String userPass, String userUser, String userType, String userSurname, boolean userState) {
		this.userName = userName;
		this.userPass = userPass;
		this.userUser = userUser;
		this.userType = userType;
		this.userSurname = userSurname;
		this.userState = userState;
	}
	
}


