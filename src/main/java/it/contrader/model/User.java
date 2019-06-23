package it.contrader.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Model dell'entità User. Contiene l'enum che definisce gli usertype (salvati come interi
 * a partire da 0 sul db).
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see UserDTO
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	public enum Usertype {
		ADMIN,
		USER,
		DOCTOR,
		ROBOT
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String name;
	@NotNull
	private String surname;
	@NotNull
	private boolean State;

	private Usertype usertype;
	
}
