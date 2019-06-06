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

		case "insert":
			final String username = request.getParameter("username");
			final String password = request.getParameter("password");
			final String name = request.getParameter("nameuser");
			final String surname = request.getParameter("surnameuser");
			final DoctorDTO doctorInsert = new DoctorDTO(name,surname,username,password,"doctor",true);
			adminServiceDTO.insertDoctor(doctorInsert);
			showAllDoctor(request, response);
			break;
					
		case "update":
			final int idUpd = Integer.parseInt(request.getParameter("id"));
			final String nameUpdate = request.getParameter("name");
			final String surnameUpdate = request.getParameter("surname");
			final String usernameUpdate = request.getParameter("username");
			final String passwordUpdate = request.getParameter("password");
			final String type = request.getParameter("type");
			final boolean state = Boolean.parseBoolean(request.getParameter("state"));
			
			final DoctorDTO doctor = new DoctorDTO(nameUpdate,surnameUpdate,usernameUpdate,passwordUpdate,type,state);
			doctor.setDoctorId(idUpd);
				
			adminServiceDTO.updateDoctor(doctor);
			showAllDoctor(request, response);
			break;
			
		case "updateRedirect": 
			
			 int id = Integer.parseInt(request.getParameter("id"));
			 System.out.println(id);
			 DoctorDTO doctorUpdate = new DoctorDTO();
			 doctorUpdate=adminServiceDTO.readDoctor(id);
			 request.setAttribute("doctorUpdate", doctorUpdate);
			 getServletContext().getRequestDispatcher("/updateAdmin.jsp").forward(request, response);
			 break;

		case "delete":
			final int doctorId = Integer.parseInt(request.getParameter("id"));
			adminServiceDTO.deleteDoctor(doctorId);
			showAllDoctor(request,response);
			break;

		case "Back":
			response.sendRedirect("homeAdmin.jsp");
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
