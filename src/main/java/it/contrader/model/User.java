package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;	

	@Column(name = "userName")
	@NotNull
	private String userName;

	@Column(name = "userPass")
	@NotNull
	private String userPass;

	@Column(name = "userUser")
	@NotNull
	private String userUser;
	
	@Column(name = "userType")
	@NotNull
	private String userType;
	
	@Column(name = "userSurname")
	@NotNull
	private String userSurname;
	
	@Column(name = "userState")
	@NotNull
	private boolean userState;

}
