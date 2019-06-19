package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import it.contrader.services.RobotService;
import it.contrader.services.UserService;


@RestController
@CrossOrigin(value="*")
@RequestMapping("/User")
public class UserController {

	private final UserService userService;
	private final RobotService robotService;
	private HttpSession session;
	
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
	}
}
