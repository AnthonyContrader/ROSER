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
@RequestMapping("Doctor")
public class DoctorController {
	private final UserService userService;
	private final RobotService robotService;
	
	@Autowired
	public DoctorController(UserService userService, RobotService robotService) {
		this.userService = userService;
		this.robotService = robotService;
	}
	
	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		request.setAttribute("user", getUser());
		return "userManagement";		
	}
	
	@RequestMapping(value = "/matchRobot", method = RequestMethod.GET)
	public String matchRobot(HttpServletRequest request) {
		int idUser = Integer.parseInt(request.getParameter("user"));
		String robotModel = request.getParameter("robot");
		
		UserDTO userDTO = userService.getUserDTOById(idUser);
		
		RobotDTO robotDTO = robotService.readRobot(robotModel);
		robotDTO.setRobotOwnerName(userDTO.getUserName());
		robotDTO.setRobotOwnerSurname(userDTO.getUserSurname());
		
		robotService.save(robotDTO);
		
		request.setAttribute("listarobot", getRobot());
		return "matchRobot";
	}
	
	@RequestMapping(value ="/matchRobotRedirect", method = RequestMethod.GET)
	public String matchRobotRedirect(HttpServletRequest request) {
		request.setAttribute("listarobot", getRobot());
		return "matchRobot";
	}
	
	@RequestMapping(value ="/matchRobotUserRedirect", method = RequestMethod.GET)
	public String matchRobotUserRedirect(HttpServletRequest request) {
		String modelRobot = request.getParameter("model");
		RobotDTO robotDTO = robotService.readRobot(modelRobot);
		List<UserDTO> listUser = getUser();
		request.setAttribute("userlist", listUser);		
		request.setAttribute("robot", robotDTO);
		return "selectUserMatch";
	}
	
	@RequestMapping(value ="/dismatchRobot", method= RequestMethod.GET)
	public String dismatcRobot(HttpServletRequest request) {
		String robotModel = request.getParameter("model");	
		RobotDTO robotDTO = robotService.readRobot(robotModel);
		robotDTO.setRobotOwnerName("");
		robotDTO.setRobotOwnerSurname("");
		robotService.save(robotDTO);
		request.setAttribute("listarobot", getRobot());
		return "matchRobot";
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
	
	public List<RobotDTO> getRobot(){
		List<RobotDTO> robotList = robotService.getAllRobotDTO();
		return robotList;
	}
}