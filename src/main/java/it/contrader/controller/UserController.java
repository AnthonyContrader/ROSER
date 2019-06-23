package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.LoginDTO;
import it.contrader.dto.RobotDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User.Usertype;
import it.contrader.service.RobotService;
import it.contrader.service.UserService;


/**
 * 
 * Questa classe estende AbstractController con tipo UserDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @param<UserDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends AbstractController<UserDTO>{
	
	@Autowired
	private UserService userService;
	
	//POST Angular a UserDTO
	@PostMapping(value = "/login")
	public UserDTO login( @RequestBody LoginDTO loginDTO ) {
		return userService.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
	}
	
	@GetMapping(value="/getUser")
	public List<UserDTO> getByUserType(@RequestParam("userType") String userType) {
		Usertype userType1 = Enum.valueOf(Usertype.class, userType);
		return userService.findUserByUsertype(userType1);
	}
	
	@PostMapping(value = "/insertRobot")
	public void insertRobot(@RequestBody RobotDTO robot) {
		
		String name = robot.getModel();
		String password = robot.getModel();
		String surname = robot.getModel();
		String username =robot.getModel();
		
		UserDTO userDTO = new UserDTO(username, password, name, surname, true, Enum.valueOf(Usertype.class, "ROBOT"));
		userService.insert(userDTO);
	}
	
	@PostMapping(value = "/deleteRobot")
	public void deleteRobot(@RequestBody RobotDTO robot)
	{
		UserDTO usrToDelete = userService.findByUsernameAndPassword(robot.getModel(), robot.getModel());
		System.out.println(usrToDelete);
		userService.delete(usrToDelete.getId());
	}
	
	
}