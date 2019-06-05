package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.converter.AdminConverter;
import it.contrader.dto.AdminDTO;
import it.contrader.dto.DoctorDTO;
import it.contrader.service.AdminServiceDTO;


/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi farà User dovrà anche occuparsi del Login che abbiamo lasciato come struttura e va modificata in modo opportuno
 *
 */
public class UsersServlet extends HttpServlet {

	private final AdminServiceDTO adminServiceDTO = new AdminServiceDTO();
	private List<DoctorDTO> allDoctor = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "UsersManager":
			showAllDoctor(request, response);
			break;			

		/*case "insert":
			final Integer id = Integer.parseInt(request.getParameter("id"));
			final String username = request.getParameter("username");
			final String password = request.getParameter("password");
			final String ruolo = request.getParameter("ruolo");
		//	final UserDTO users = new UserDTO(id,username, password, ruolo);
		//	usersServiceDTO.insertUser(users);
			showAllUsers(request, response);
			break;
					
		case "update":
			System.out.println("id: "+Integer.parseInt(request.getParameter("id")));
			System.out.println("username: "+request.getParameter("username"));
			System.out.println("password: "+request.getParameter("password"));
			System.out.println("ruolo: "+request.getParameter("ruolo"));

		     	
			final Integer idUpdate = Integer.parseInt(request.getParameter("id"));
			final String usernameUpdate = request.getParameter("username");
			final String passwordUpdate = request.getParameter("password");
			final String ruoloUpdate = request.getParameter("ruolo");
		//	final UserDTO user = new UserDTO(idUpdate, usernameUpdate,passwordUpdate, ruoloUpdate);
					
				
					
		//	usersServiceDTO.updateUser(user);
			showAllUsers(request, response);
			break;*/

		case "delete":
			System.out.println("ciao");
			final int doctorId = Integer.parseInt(request.getParameter("id"));
			System.out.println(doctorId);
			adminServiceDTO.deleteDoctor(doctorId);
			System.out.println("ciao");
			showAllDoctor(request,response);
			break;

		case "Indietro":
			response.sendRedirect("home.jsp");
			break;

		case "LogsMenu":
			response.sendRedirect("homeLogs.jsp");
			break;

				}

			}

		

	

	private void showAllDoctor(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		allDoctor = this.adminServiceDTO.getAllDoctor();
		request.setAttribute("doctor", allDoctor);
		getServletContext().getRequestDispatcher("/manageUsers.jsp").forward(request, response);
	}
}
