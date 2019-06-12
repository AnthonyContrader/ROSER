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
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		String nameInsert = request.getParameter("user_name");
		String surnameInsert = request.getParameter("user_surname");
		String userNameInsert = request.getParameter("user_user");
		String passwordInsert = request.getParameter("user_pass");
		UserDTO doctorToInsert = new UserDTO(nameInsert,surnameInsert,userNameInsert,passwordInsert,"doctor",true);
		userService.insertUser(doctorToInsert);
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
