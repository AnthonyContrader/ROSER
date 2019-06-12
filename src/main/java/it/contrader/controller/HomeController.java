package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;

@Controller
@RequestMapping("/Home")
public class HomeController {

	private final UserService userService;

	@Autowired
	public HomeController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/doctorManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		List<UserDTO> tmpUser = this.userService.getListaUserDTO();
		List<UserDTO> doctorList = new ArrayList<>();
		
		for(UserDTO user: tmpUser)
		{
			if(user.getUserType().equals("doctor"))
				doctorList.add(user);
		}
		
		request.setAttribute("user", doctorList);
		return "doctorManagment";

	}
	
	/*@RequestMapping(value = "/devicesManagement", method = RequestMethod.GET)
	public String devicesManagement(HttpServletRequest request) {
		return "devicesManagement";

	}*/

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		return "index";

	}
	@RequestMapping(value = "/indietro", method = RequestMethod.GET)
	public String indietro(HttpServletRequest request) {
		return "home";

	}
}