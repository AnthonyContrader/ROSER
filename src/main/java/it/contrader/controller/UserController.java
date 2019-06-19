package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

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


import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;
import it.contrader.services.RobotService;


@RestController
@CrossOrigin(value="*")
@RequestMapping("/User")
public class UserController {


private RobotService robotService;
private UserService userService;

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


	
	@Autowired

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

}}