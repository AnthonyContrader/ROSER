package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.DoctorDTO;
import it.contrader.dto.RobotDTO;
import it.contrader.service.AdminServiceDTO;

/**
 * Servlet implementation class DevicesServlet
 */
public class DevicesServlet extends HttpServlet {
	private final AdminServiceDTO adminServiceDTO = new AdminServiceDTO();
	private List<RobotDTO> allRobot = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "DevicesManager":
			showAllDoctor(request, response);
			break;			

		case "insert":
			final String username = request.getParameter("username");
			final String password = request.getParameter("password");
			final String name = request.getParameter("nameuser");
			final String surname = request.getParameter("surnameuser");
			//int robotId,String name,String surname,String username,String password,String type, boolean state
			final RobotDTO robotInsert = new RobotDTO();
			robotInsert.setName(name);
			robotInsert.setSurname(surname);
			robotInsert.setUsername(username);
			System.out.println(surname);
			robotInsert.setPassword(password);
			robotInsert.setType("robot");
			robotInsert.setState(true);
			robotInsert.setRobotModel(username);
			robotInsert.setRobot_owner_name("");
			robotInsert.setRobot_owner_surname("");
			adminServiceDTO.insertRobot(robotInsert);
			showAllDoctor(request, response);
			break;
					
	/*	case "update":
			final int idUpd = Integer.parseInt(request.getParameter("id"));
			final String nameUpdate = "robot";
			final String surnameUpdate = "robot";
			final String usernameUpdate = request.getParameter("username");
			final String passwordUpdate = request.getParameter("password");
			final String type = "robot";
			final boolean state = true;
			
			//int robotId,String name,String surname,String username,String password,String type, boolean state
			final RobotDTO robot = new RobotDTO(idUpd,nameUpdate,surnameUpdate,usernameUpdate,passwordUpdate,type,state);
			robot.setRobot_id(idUpd);
				
			adminServiceDTO.updateRobot(robot);
			showAllDoctor(request, response);
			break;
		
		case "updateRedirect": 
			
			 int id = Integer.parseInt(request.getParameter("id"));
			 System.out.println(id);
			 RobotDTO robotUpdate = new RobotDTO();
			 robotUpdate=adminServiceDTO.readRobot(id);
			 request.setAttribute("RobotUpdate", robotUpdate);
			 getServletContext().getRequestDispatcher("/updateAdminRobot.jsp").forward(request, response);
			 break;*/

		case "delete":
			final String robotModel = request.getParameter("id");
			adminServiceDTO.deleteRobot(robotModel);
			showAllDoctor(request,response);
			break;

		case "Back":
			response.sendRedirect("homeAdmin.jsp");
			break;

				}

			}
	
	private void showAllDoctor(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		allRobot = this.adminServiceDTO.getAllRobot();
		request.setAttribute("robot", allRobot);
		getServletContext().getRequestDispatcher("/manageRobot.jsp").forward(request, response);
	}

}
