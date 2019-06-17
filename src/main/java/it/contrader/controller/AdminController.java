package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.RobotDTO;
import it.contrader.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.services.RobotService;
import it.contrader.services.UserService;

@Controller
@RequestMapping("Admin")
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private RobotService robotService;
	
	
	@RequestMapping(value = "/doctorManagement", method = RequestMethod.GET)
	public String doctorManagement(HttpServletRequest request) {
		request.setAttribute("doctor", getDoctor());
		return "doctorManagement";		
	}
	
	@RequestMapping(value = "/devicesManagement", method = RequestMethod.GET)
	public String devicesManagement(HttpServletRequest request) {
		request.setAttribute("robot", getRobot());
		return "devicesManagement";		
	}
	
	@RequestMapping(value ="/deleteDoctor", method = RequestMethod.GET)
	public String deleteDoctor(HttpServletRequest request) {
		int idDoctor = Integer.parseInt(request.getParameter("id"));
		userService.deleteUserById(idDoctor);
		request.setAttribute("doctor", getDoctor());
		return "doctorManagement";
	}
	
	@RequestMapping(value ="/deleteRobot", method = RequestMethod.GET)
	public String deleteRobot(HttpServletRequest request) {
		int idRobot = Integer.parseInt(request.getParameter("id"));
		userService.deleteUserById(idRobot);
		request.setAttribute("robot", getRobot());
		return "devicesManagement";
	}
	
	@RequestMapping(value = "/updateDoctor", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request)
	{
		int idUpd = Integer.parseInt(request.getParameter("id"));
		String nameUpdate = request.getParameter("name");
		String surnameUpdate = request.getParameter("surname");
		String usernameUpdate = request.getParameter("username");
		String passwordUpdate = request.getParameter("password");
		//String type = request.getParameter("type");
		boolean state = Boolean.parseBoolean(request.getParameter("state"));
		
		final UserDTO doctor = new UserDTO(nameUpdate,passwordUpdate,usernameUpdate,"doctor",surnameUpdate,state);
		doctor.setUserId(idUpd);
		
		userService.updateUser(doctor);
		request.setAttribute("doctor", getDoctor());
		return "doctorManagement";	
		
	}
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int idDoctor = Integer.parseInt(request.getParameter("id"));
		
		UserDTO doctor = userService.getUserDTOById(idDoctor);
		
		request.setAttribute("doctor", doctor);
		return "updateDoctor";
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
	
	@RequestMapping(value = "/insertRobot", method = RequestMethod.POST)
	public String insertRobot(HttpServletRequest request) {
		
		String userName = request.getParameter("user_name");
		String userPass = request.getParameter("user_pass");
		String userSurname = request.getParameter("user_surname");
		String userUser = request.getParameter("user_user");
		
		UserDTO userDTO = new UserDTO(userName, userPass, userUser, "robot", userSurname, true);
		RobotDTO robotDTO = new RobotDTO(userUser, "", "");
		
		robotDTO.setRobotModel(userUser);
		userService.insertUser(userDTO);
		robotService.insertRobot(robotDTO);
		
		request.setAttribute("robot", getRobot());
		
		return "devicesManagement";		
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
	
	public List<UserDTO> getRobot() {
		List<UserDTO> tmpList = userService.getListaUserDTO();
		List<UserDTO> robotList = new ArrayList<>();
		for(UserDTO user: tmpList) {
			if(user.getUserType().equals("robot")) {
				robotList.add(user);
			}
		}
		return robotList;
	}
	
}
