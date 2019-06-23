package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO della classe User. Ha gli stessi attributi di User
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see User
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class UserDTO {

	private long id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private boolean state;

	private Usertype usertype;
	
	public UserDTO(String username,String password,String name, String surname,boolean state,Usertype usertype){
		
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.state = state;
		this.usertype = usertype;
		
	}
	

}
