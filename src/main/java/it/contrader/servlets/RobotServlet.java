package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.RobotDTO;
import it.contrader.service.RobotServiceDTO;


public class RobotServlet extends HttpServlet {

	private final RobotServiceDTO robotServiceDTO = new RobotServiceDTO();
	private List<RobotDTO> allRobot= new ArrayList<>();
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "RobotManager":
			allRobot = this.robotServiceDTO.getAllRobot();
			request.setAttribute("allRobot", allRobot);
			getServletContext().getRequestDispatcher("/robot.jsp").forward(request, response);
			break;			

		case "insert":
			final Integer id = Integer.parseInt(request.getParameter("id"));
			final String username = request.getParameter("username");
			final String password = request.getParameter("password");
			final String modello = request.getParameter("modello");
		//	final UserDTO users = new UserDTO(id,username, password, ruolo);
		//	usersServiceDTO.insertUser(users);
			showAllRobot(request, response);
			break;
					
		case "update":
			System.out.println("id: "+Integer.parseInt(request.getParameter("id")));
			System.out.println("username: "+request.getParameter("username"));
			System.out.println("password: "+request.getParameter("password"));
			System.out.println("modello: "+request.getParameter("modello"));

		     	
			final Integer idUpdate = Integer.parseInt(request.getParameter("id"));
			final String usernameUpdate = request.getParameter("username");
			final String passwordUpdate = request.getParameter("password");
			final String modelloUpdate = request.getParameter("modello");
		//	final UserDTO user = new UserDTO(idUpdate, usernameUpdate,passwordUpdate, ruoloUpdate);
					
				
					
		//	usersServiceDTO.updateUser(user);
			showAllRobot(request, response);
			break;

		case "delete":
			final Integer idUpdat = Integer.parseInt(request.getParameter("id"));
			
		//	final UserDTO use = new UserDTO(idUpdat,"" ,"","");
		//	usersServiceDTO.deleteUser(use);
			showAllRobot(request, response);
			break;

		case "Indietro":
			response.sendRedirect("home.jsp");
			break;

		case "LogsMenu":
			response.sendRedirect("homeLogs.jsp");
			break;

				}

			}

		

	

private void showAllRobot(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	allRobot = this.robotServiceDTO.getAllRobot();
	request.setAttribute("allRobot", allRobot);
	getServletContext().getRequestDispatcher("/robot.jsp").forward(request, response);
}
	
}
