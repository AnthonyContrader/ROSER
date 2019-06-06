package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.contrader.dto.UsersDTO;
import it.contrader.service.UsersServiceDTO;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet 
{

	private final UsersServiceDTO usersServiceDTO = new UsersServiceDTO();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);

		if (request != null) {
			final String nomeUtente = request.getParameter("username").toString();
			
			final String password = request.getParameter("password").toString();
			
			// recuperiamo l'utente
			final UsersDTO usersDTO = usersServiceDTO.getUsersByUserNameAndPassword(nomeUtente, password);
			
				if (usersDTO != null) {
					try {
						session.setAttribute("utente", usersDTO.getUserName());
						// verifichiamo che tipo di ruolo ha all'interno dell'applicazione
						// e lo reindirizziamo nella jsp opportuna
						switch (usersDTO.getUserType()) 
						{
							case "admin":
								getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
								break;
							case "user": //da controllare
								getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
								break;
							case "doctor":
								getServletContext().getRequestDispatcher("/homeDoctor.jsp").forward(request, response);
								break;
							default:
								getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
								break;
						}
					}catch(Exception e) {
						session.setAttribute("error", "WRONG USER OR PASSWORD");
						getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);	
					}
				}
			else {
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
	}
}
