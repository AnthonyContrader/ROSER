package it.contrader.servlets.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.RobotDTO;
import it.contrader.dto.UsersDTO;
import it.contrader.service.RobotService;
import it.contrader.service.UsersService;

public class RobotManagementServlet extends HttpServlet {
	private final RobotService robotService = new RobotService();
	private final UsersService usersService = new UsersService();
	private final List<RobotDTO> doctorList = new ArrayList<>();
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		
		switch(scelta) {
			case "RobotManager":
				showAllRobot(request, response);
				break;
				
			case "Delete":
				String robotModel = request.getParameter("robot_model");
				RobotDTO robotDelete = new RobotDTO();
				robotDelete.setRobotModel(robotModel);
				robotService.deleteRobot(robotDelete);
				showAllRobot(request, response);
				break;
				
			case "Insert":
				String robotName = request.getParameter("user_name");
				String robotSurname = request.getParameter("user_surname");
				String robotModelInsert = request.getParameter("user_user");
				String robotPassword = request.getParameter("user_pass");
				RobotDTO robotInsert = new RobotDTO(robotName, robotSurname, robotPassword, robotModelInsert, " ", " ");
				robotService.insertUsers(robotInsert);
				showAllRobot(request, response);
			case "MatchRedirect":
				List<RobotDTO> robots = robotService.getAllRobot();
				request.setAttribute("robots", robots);
				getServletContext().getRequestDispatcher("/matchRobot.jsp").forward(request, response);
				break;
			case "UserToMatchRedirect":
				String robotModelMatch = request.getParameter("robot");
				RobotDTO robot = robotService.readRobot(robotModelMatch);
				List<UsersDTO> users = new ArrayList<>();
				
				List<UsersDTO> tempList = usersService.getAllUsers();
				for(UsersDTO use: tempList) {
					if(use.getUserType().equals("users")) {
						users.add(use);
					}
				}
				request.setAttribute("users", users);
				request.setAttribute("robot", robot);
				getServletContext().getRequestDispatcher("/userToMatch.jsp").forward(request, response);
				break;
			case "Match":
				String robotModelMatching = request.getParameter("robot");
				int userIdMatch = Integer.parseInt(request.getParameter("user"));
				
				RobotDTO robotMatch = robotService.readRobot(robotModelMatching);
				UsersDTO userMatch = usersService.readUser(userIdMatch);
				robotService.matchUsers(userMatch,robotMatch);
				showAllRobot(request,response);
				break;
			case "Dismatch":
				String robotModelDismatching = request.getParameter("robot");
				RobotDTO robotDimatch = robotService.readRobot(robotModelDismatching);
				robotService.disMatchUsers(robotDimatch);
				showAllRobot(request,response);
				break;
		}	
	}
	
	public void showAllRobot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Preleviamo tutti gli utenti
		List<RobotDTO> listRobot = robotService.getAllRobot();
		request.setAttribute("robot", listRobot);
		getServletContext().getRequestDispatcher("/robotManagement.jsp").forward(request, response);
	}
}
