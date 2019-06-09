package it.contrader.servlets.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.UsersDTO;
import it.contrader.service.UsersService;

/**
 * Servlet implementation class AdminServlet
 */
public class DoctorManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UsersService userService = new UsersService();
	private List<UsersDTO> doctorList = new ArrayList<>();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		
		switch(scelta) {
			case "DoctorManager":
				showAllDoctor(request, response);
				break;
			case "Insert":
				String nameInsert = request.getParameter("user_name");
				String surnameInsert = request.getParameter("user_surname");
				String userNameInsert = request.getParameter("user_user");
				String passwordInsert = request.getParameter("user_pass");
				UsersDTO doctorToInsert = new UsersDTO(nameInsert,surnameInsert,userNameInsert,passwordInsert,"doctor",true);
				userService.insertUsers(doctorToInsert);
				showAllDoctor(request, response);
				break;
			case "UdpateRedirect":
				UsersDTO readUsers = userService.readUser(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("doctor", readUsers);
				getServletContext().getRequestDispatcher("/updateDoctor.jsp").forward(request, response);
				break;
			case "Update":
				int userId = Integer.parseInt(request.getParameter("user_id"));
				String nameUpdate = request.getParameter("name");
				String surnameUpdate = request.getParameter("surname");
				String userNameUpdate = request.getParameter("username");
				String passwordUpdate = request.getParameter("password");
				boolean state = Boolean.parseBoolean(request.getParameter("state"));
				UsersDTO doctorToUpdate = new UsersDTO(userId,nameUpdate,surnameUpdate,userNameUpdate,passwordUpdate,"doctor",state);
				userService.updateUsers(doctorToUpdate);
				showAllDoctor(request, response);
				break;
			case "Delete":
				int id = Integer.parseInt(request.getParameter("user_id"));
				UsersDTO deleteDoctor = new UsersDTO(id);
				userService.deleteUsers(deleteDoctor);
				showAllDoctor(request, response);
				break;
		}	
	}
	
	private void showAllDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Preleviamo tutti gli utenti
		List<UsersDTO> listUser = userService.getAllUsers();
		
		//Generiamo un'latra lista che conterrà solo gli utenti richiesti
		doctorList = new ArrayList<>();
		for(UsersDTO user: listUser) {
			if(user.getUserType().equals("doctor")) {
				doctorList.add(user);
			}
		}
		request.setAttribute("doctor", doctorList);
		getServletContext().getRequestDispatcher("/doctorManagement.jsp").forward(request, response);
	}
}
