package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.RobotDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.RobotService;
import it.contrader.services.UserService;


@Controller
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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {
		try {
		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String ruolo = userDTO.getUserType();
		
		if (!StringUtils.isEmpty(ruolo)) {
			session.setAttribute("utenteCollegato", userDTO);
			
			switch (ruolo)
			{
			case "admin":
				
				List<UserDTO> tmpUser= userService.getListaUserDTO();
				List<UserDTO> doctorList = new ArrayList<>();
				for(UserDTO user: tmpUser) {
					if(user.getUserType().equals("doctor")) {
						doctorList.add(user);
					}
				}
				int doctorNumber = doctorList.size();
				
				List<RobotDTO> robotList = robotService.getAllRobotDTO();
				int robotNumber = robotList.size();
				session.setAttribute("utenteCollegato", userDTO.getUserUser());
				session.setAttribute("doctorNumber", doctorNumber);
				session.setAttribute("robotNumber", robotNumber);
				request.setAttribute("errore", "");
				return "homeAdmin";
				
			case "robot":
				session.setAttribute("utenteCollegato", userDTO.getUserUser());
				request.setAttribute("errore", "");
				return "homeRobot";
				
			case "doctor":
				List<UserDTO> tmpUserList = userService.getListaUserDTO();
				List<UserDTO> userList = new ArrayList<>();
				for(UserDTO user: tmpUserList) {
					if(user.getUserType().equals("user")) {
						userList.add(user);
					}
				}
				int patientNumber = userList.size();
				session.setAttribute("patientnumber", patientNumber);
				session.setAttribute("utenteCollegato", userDTO.getUserUser());
				request.setAttribute("errore", "");
				return "homeDoctor";
				
			case "user":
				session.setAttribute("utenteCollegato", userDTO.getUserUser());
				request.setAttribute("errore", "");
				return "homeUser";
				
				default:
					request.setAttribute("errore", "");
					return "index";
			}
		}
		}catch(Exception ex) {
			request.setAttribute("errore", "Wrong username or password");
			return "index";
		}
		return "index";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}
