package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.UserDTO;
import it.contrader.service.UsersServiceDTO;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet 
{

	private final UsersServiceDTO usersServiceDTO = new UsersServiceDTO();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);
		

		if (request != null) {
			final String nomeUtente = request.getParameter("username").toString();
			
			final String password = request.getParameter("password").toString();
			
			// recuperiamo l'utente
			final UserDTO usersDTO = usersServiceDTO.getUserByUsernameAndPasword(nomeUtente, password);

			if (usersDTO != null)
			{
				session.setAttribute("utente", usersDTO.getUsername());
			
			// verifichiamo che tipo di ruolo ha all'interno dell'applicazione
			// e lo reindirizziamo nella jsp opportuna
				switch (usersDTO.getUsertype()) 
				{
					case "admin":
						List<UserDTO> tmpUserDTO= usersServiceDTO.getAllUser();
						String tmpUserData="";
						System.out.println("XXXXXXXXXX");
						for(UserDTO usr : tmpUserDTO)
						{
							tmpUserData += "<tr>";
							tmpUserData += "<td>"+usr.getUserId()+"</td> <td>"+usr.getName() +"</td> <td>"+usr.getSurname()+"</td> <td>"+usr.getUsername()+"</td> <td>"+usr.getPassword()+"</td> <td>"+usr.isUserState()+"</td>";
							tmpUserData += "<td>"+"<button type=\"submit\" value=\"Delete"+usr.getUserId()+"\" name=\"pulsante\">Delete</button></td>";
							tmpUserData += "<td>"+"<button type=\"submit\" value=\"Update\" name=\"pulsante\">Update</button></td>";
							tmpUserData += "</tr>";
							
							System.out.println(tmpUserData+"XXXXXXXXXX");
							
						}
						session.setAttribute("posts", tmpUserData);
						getServletContext().getRequestDispatcher("/manageUsers.jsp").forward(request, response);
						break;
				
					case "user":
						getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
						break;
				
					case "doctor":
						getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
						break;
				
					default:
						getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
						break;
				}
		
			}
			else
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
}
