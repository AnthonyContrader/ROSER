package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;

@Controller
@RequestMapping("/Doctor")
public class DoctorController {
	
	private final UserService userService;
	
	@Autowired
	public DoctorController(UserService userService) {

		this.userService = userService;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		userService.deleteUserById(id);
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		List<UserDTO> tmpUsers = new ArrayList<>();
		
		for(UserDTO user: allUser)
		{
			if(user.getUserType().equals("doctor"))
				tmpUsers.add(user);
		}
		
		request.setAttribute("user", tmpUsers);
		return "doctorManagment";
	}
	
}
