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
@RequestMapping("Doctor")
public class DoctorController {
	private final UserService userService;
	
	@Autowired
	public DoctorController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		request.setAttribute("user", getUser());
		return "userManagement";		
	}
	
	@RequestMapping(value ="/deleteUser", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest request) {
		int idUser = Integer.parseInt(request.getParameter("id"));
		userService.deleteUserById(idUser);
		request.setAttribute("user", getUser());
		return "userManagement";
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request)
	{
		int idUpd = Integer.parseInt(request.getParameter("id"));
		String nameUpdate = request.getParameter("name");
		String surnameUpdate = request.getParameter("surname");
		String usernameUpdate = request.getParameter("username");
		String passwordUpdate = request.getParameter("password");
		//String type = request.getParameter("type");
		boolean state = Boolean.parseBoolean(request.getParameter("state"));
		
		final UserDTO user = new UserDTO(nameUpdate,passwordUpdate,usernameUpdate,"user",surnameUpdate,state);
		user.setUserId(idUpd);
		
		userService.updateUser(user);
		request.setAttribute("user", getUser());
		return "userManagement";	
		
	}
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int idUser = Integer.parseInt(request.getParameter("id"));
		
		UserDTO user = userService.getUserDTOById(idUser);
		
		request.setAttribute("user", user);
		return "updateUser";
	}
	
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String insertUser(HttpServletRequest request) {
		
		String userName = request.getParameter("user_name");
		String userPass = request.getParameter("user_pass");
		String userSurname = request.getParameter("user_surname");
		String userUser = request.getParameter("user_user");
		
		UserDTO userDTO = new UserDTO(userName, userPass, userUser, "user", userSurname, true);
		
		userService.insertUser(userDTO);
		
		request.setAttribute("user", getUser());
		
		return "userManagement";		
	}
	
	public List<UserDTO> getUser() {
		List<UserDTO> tmpList = userService.getListaUserDTO();
		List<UserDTO> userList = new ArrayList<>();
		for(UserDTO user: tmpList) {
			if(user.getUserType().equals("user")) {
				userList.add(user);
			}
		}
		return userList;
	}
}