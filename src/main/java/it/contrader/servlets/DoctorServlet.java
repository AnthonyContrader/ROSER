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
			
		case "insert":
			//String userType, boolean userState
			UsersDTO users = new UsersDTO();
			users.setName(request.getParameter("nameuser"));
			users.setSurname(request.getParameter("surnameuser"));
			users.setUserName(request.getParameter("username"));
			users.setPassword(request.getParameter("password"));
			users.setUserType("user");
			users.setUserState(true);
			doctorServiceDTO.insertPatient(users);
			showAllPatient(request,response);
			break;

		case "delete":
			final int patientId = Integer.parseInt(request.getParameter("id"));
			doctorServiceDTO.deletePatient(patientId);
			showAllPatient(request,response);
			break;
			
		case "updateredirect":
			int id = Integer.parseInt(request.getParameter("id"));
			 System.out.println(id);
			 UsersDTO usersUpdate = new UsersDTO();
			 usersUpdate = doctorServiceDTO.readPatient(id);
			 request.setAttribute("usersUpdate", usersUpdate);
			 getServletContext().getRequestDispatcher("/updateDoctor.jsp").forward(request, response);
			 break;
			 
		case "update":
			final int idUpd = Integer.parseInt(request.getParameter("id"));
			final String nameUpdate = request.getParameter("name");
			final String surnameUpdate = request.getParameter("surname");
			final String usernameUpdate = request.getParameter("username");
			final String passwordUpdate = request.getParameter("password");
			final String type = request.getParameter("type");
			final boolean state = Boolean.parseBoolean(request.getParameter("state"));
			
			final UsersDTO user = new UsersDTO();
			user.setName(nameUpdate);
			user.setSurname(surnameUpdate);
			user.setUserName(usernameUpdate);
			user.setPassword(passwordUpdate);
			user.setUserType(type);
			user.setUserState(state);
			user.setUserId(idUpd);
				
			doctorServiceDTO.updateDoctor(user);
			showAllPatient(request, response);
			break;


		case "Indietro":
			response.sendRedirect("home.jsp");
			break;
			
		case "bakc":
			response.sendRedirect("homeDoctor.jsp");
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
