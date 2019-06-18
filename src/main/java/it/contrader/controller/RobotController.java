package it.contrader.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.RobotDTO;
import it.contrader.dto.SensordataDTO;
import it.contrader.services.RobotService;
import it.contrader.services.SensordataService;

@Controller
@RequestMapping("Robot")
public class RobotController {
	@Autowired
	private SensordataService sensordataService;
	@Autowired
	private RobotService robotService;
	
	@RequestMapping(value = "/readParameter", method = RequestMethod.GET)
	public String readParameter(HttpServletRequest request) {
		String robotModel= request.getParameter("robot");
		int decibel = getValue();
		int faceExpress = getValue();
		int humidity = getValue();
		String data = getData();
		RobotDTO robotDTO = robotService.readRobot(robotModel);
		String patientName = robotDTO.getRobotOwnerName();
		String patientSurname = robotDTO.getRobotOwnerSurname();
		SensordataDTO sensordataDTO = new SensordataDTO(robotModel, decibel, faceExpress, humidity, data, patientName, patientSurname);
		
		List<SensordataDTO> dataList = sensordataService.findDataByRobotModel(robotModel);
		
		if(dataList.size() >=10) {
			sensordataService.deleteDataById(dataList.get(0).getDataId());
		}
		
		sensordataService.insertData(sensordataDTO);		
		String[] tmpUmor = new String[2];
		tmpUmor = getMedia(decibel, faceExpress, humidity);
		request.setAttribute("url", tmpUmor[0]);
		request.setAttribute("emotion",tmpUmor[1]);
		request.setAttribute("data",sensordataDTO);
		
		return "patientHumor";			
	}
	
	@RequestMapping(value ="/showLog", method = RequestMethod.GET)
	public String showLog(HttpServletRequest request) {
		String robotModel= request.getParameter("robot");
		List<SensordataDTO> data = sensordataService.findDataByRobotModel(robotModel);
		request.setAttribute("log", data);
		return "showLog";
	}
/*	
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
	}*/
	
	public int getValue() {
		Random r = new Random();
		return r.nextInt(9)+1;
	}
	
	public String getData() {
		String dataStr = "";
		Date data = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		dataStr = format.format(data);
		return dataStr;
	}
	
	public String[] getMedia(int decibel, int faceExpress, int humidity) {
		int media = (decibel+faceExpress+humidity)/3;
		String[] url = new String[2];
		if(media>0 && media<4) {
			url[0] = "/img/0_3.png";
			url[1] = "SAD";	
		}
		else if(media>3 && media<7) {
			url[0] = "/img/4_6.png";
			url[1] = "NORMAL";
		}
		else {
			url[0] = "/img/7_9.png";
			url[1] = "HAPPY";
		}
		return url;
	}
	
}