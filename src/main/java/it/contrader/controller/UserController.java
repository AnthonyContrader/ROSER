package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.LoginDTO;
import it.contrader.dto.RobotDTO;
=======

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.LoginDTO;
>>>>>>> 37b57d3e7de8a2ec87bd9cc856c12b1afdaacfbd
import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

<<<<<<< HEAD
@RestController
@CrossOrigin(value="*")
@RequestMapping("/User")
public class UserController {
=======
>>>>>>> 37b57d3e7de8a2ec87bd9cc856c12b1afdaacfbd

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
<<<<<<< HEAD
	public UserController(UserService userService, RobotService robotService) {
		this.userService = userService;
		this.robotService = robotService;
	}
	
	@PostMapping(value = "/login")
	public UserDTO login(@RequestBody LoginDTO x) {
		final UserDTO userDTO = userService.getByUsernameAndPassword(x.getUsername(), x.getPassword());
		final String ruolo = userDTO.getUserType();
		return userDTO;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
=======
	private UserService userService;


	//POST Angular a UserDTO
	@PostMapping(value = "/login")
	public UserDTO login( @RequestBody LoginDTO loginDTO ) {
		return userService.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
>>>>>>> 37b57d3e7de8a2ec87bd9cc856c12b1afdaacfbd
	}
}