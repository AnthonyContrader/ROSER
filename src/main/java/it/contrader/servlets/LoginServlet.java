package it.contrader.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.UsersDTO;
import it.contrader.service.UsersServiceDTO;

public class LoginServlet extends HttpServlet {

	private final UsersServiceDTO usersServiceDTO = new UsersServiceDTO();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("utente", null);
		
		if (request != null) {
			String nomeUtente = request.getParameter("user");
			String password = request.getParameter("user_pass");
			// recuperiamo l'utente
			UsersDTO usersDTO = usersServiceDTO.getUserByUsernameAndPasword(nomeUtente, password);

			if (usersDTO != null)
				session.setAttribute("users", usersDTO);

			// verifichiamo che tipo di ruolo ha all'interno dell'applicazione
			// e lo reindirizziamo nella jsp opportuna
			switch (usersDTO.getUserType()) {
			case "admin":
				getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
				break;
			case "user":
				getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
				break;
			default:
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
		}
	}

}
