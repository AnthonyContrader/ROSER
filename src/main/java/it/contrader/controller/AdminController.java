package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.services.UserService;

@Controller
@RequestMapping("Admin")
public class AdminController {
	private final UserService userService;
	
	@Autowired
	public AdminController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/doctorManagement", method = RequestMethod.GET)
	public String doctorManagement(HttpServletRequest request) {
		request.setAttribute("doctor", getDoctor());
		return "doctorManagement";		
	}
	
	@RequestMapping(value ="/deleteDoctor", method = RequestMethod.GET)
	public String deleteDoctor(HttpServletRequest request) {
		int idDoctor = Integer.parseInt(request.getParameter("id"));
		userService.deleteUserById(idDoctor);
		request.setAttribute("doctor", getDoctor());
		return "doctorManagement";
	}
	
	@RequestMapping(value = "/insertDoctor", method = RequestMethod.POST)
	public String insertDoctor(HttpServletRequest request) {
		
		String userName = request.getParameter("user_name");
		String userPass = request.getParameter("user_pass");
		String userSurname = request.getParameter("user_surname");
		String userUser = request.getParameter("user_user");
		
		UserDTO userDTO = new UserDTO(userName, userPass, userUser, "doctor", userSurname, true);
		
		userService.insertUser(userDTO);
		
		request.setAttribute("doctor", getDoctor());
		
		return "doctorManagement";		
	}
	
	public List<UserDTO> getDoctor() {
		List<UserDTO> tmpList = userService.getListaUserDTO();
		List<UserDTO> doctorList = new ArrayList<>();
		for(UserDTO user: tmpList) {
			if(user.getUserType().equals("doctor")) {
				doctorList.add(user);
			}
		}
		return doctorList;
	}
}
