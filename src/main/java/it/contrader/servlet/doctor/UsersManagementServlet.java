package it.contrader.servlet.doctor;

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

public class UsersManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final UsersService userService = new UsersService();
	private List<UsersDTO> usersList = new ArrayList<>();
	
    
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		
		switch(scelta) {
			case "UserManager":
				showAllUsers(request,response);
				break;
			case "Delete":
				int userId = Integer.parseInt(request.getParameter("user_id"));
				UsersDTO userDelete = new UsersDTO(userId);
				userService.deleteUsers(userDelete);
				showAllUsers(request, response);
				break;
			case "UpdateRedirect":
				UsersDTO readUsers = userService.readUser(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("users", readUsers);
				getServletContext().getRequestDispatcher("/updateUsers.jsp").forward(request, response);
				break;
			case "Update":
				int userIdUpdate = Integer.parseInt(request.getParameter("user_id"));
				String nameUpdate = request.getParameter("name");
				String surnameUpdate = request.getParameter("surname");
				String userNameUpdate = request.getParameter("username");
				String passwordUpdate = request.getParameter("password");
				boolean state = Boolean.parseBoolean(request.getParameter("state"));
				UsersDTO userUpdate = new UsersDTO(userIdUpdate,nameUpdate,surnameUpdate,userNameUpdate,passwordUpdate,"users",state);
				userService.updateUsers(userUpdate);
				showAllUsers(request, response);
				break;
			case "Insert":
				String name = request.getParameter("name");
				String surname = request.getParameter("surname");
				String user = request.getParameter("user");
				String pass = request.getParameter("pass");
				UsersDTO userInsert = new UsersDTO(name, surname, user, pass, "users", true);
				userService.insertUsers(userInsert);
				showAllUsers(request, response);
				break;
		}
		
	}
	
	public void showAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Preleviamo tutti gli utenti
		List<UsersDTO> listUser = userService.getAllUsers();
		
		//Generiamo un'latra lista che conterrà solo gli utenti richiesti
		usersList = new ArrayList<>();
		for(UsersDTO user: listUser) {
			if(user.getUserType().equals("users")) {
				usersList.add(user);
				}
			}
		request.setAttribute("users", usersList);
		getServletContext().getRequestDispatcher("/usersManagement.jsp").forward(request, response);
	}
}