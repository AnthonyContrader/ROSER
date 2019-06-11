package it.contrader.dto;

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

	
}


