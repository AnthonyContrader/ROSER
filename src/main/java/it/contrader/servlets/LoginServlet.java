package it.contrader.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.UsersDTO;
import it.contrader.service.UsersService;

public class LoginServlet extends HttpServlet {

	private final UsersService usersService = new UsersService();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession();
		session.setAttribute("utente", null); // ("etichetta per l'invio dei dati", dato inviato);
		
		if (request != null) {
			
			//Viene preso il parametro in ingresso
			//request.getParameter("etichetta per l'invio dei dati della pagina a cui e collegata la classe");
			
			final String nomeUtente = request.getParameter("user_user");
			final String password = request.getParameter("user_pass");
	
			final UsersDTO usersDTO = usersService.getUserByUsernameAndPasword(nomeUtente, password);
			try {
				if (usersDTO != null)
					session.setAttribute("utente", usersDTO.getUserUser());
			
				//In base al parametro dello switch aprira una pagina dedicata
				switch (usersDTO.getUserType()) {
					case "admin":
						getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
						break;
					case "doctor":
						getServletContext().getRequestDispatcher("/homeDoctor.jsp").forward(request, response);
						break;
					case "robot":
						getServletContext().getRequestDispatcher("/homeRobot.jsp").forward(request, response);
						break;
					/*case "user":
						getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
						break;*/
					default:
						getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
						break;
				}
			}catch(Exception ex) {
				session.setAttribute("errore", "WRONG PASSWORD OR USERNAME");
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
	}

}
