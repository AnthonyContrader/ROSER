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
import it.contrader.dto.UsersDTO;
import it.contrader.service.DoctorServiceDTO;


public class DoctorServlet extends HttpServlet {
       
	private final DoctorServiceDTO doctorServiceDTO = new DoctorServiceDTO();
	private List<UsersDTO> allPatient = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "PatientManager":
			showAllPatient(request, response);
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
			final int patientId = Integer.parseInt(request.getParameter("id"));
			System.out.println(patientId);
			doctorServiceDTO.deletePatient(patientId);
			System.out.println("ciao");
			showAllPatient(request,response);
			break;

		case "Indietro":
			response.sendRedirect("home.jsp");
			break;

		case "LogsMenu":
			response.sendRedirect("homeLogs.jsp");
			break;

				}

			}


	private void showAllPatient(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		allPatient = this.doctorServiceDTO.getAllPatient();
		request.setAttribute("patient", allPatient);
		getServletContext().getRequestDispatcher("/managePatient.jsp").forward(request, response);
	}

}
