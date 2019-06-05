package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.converter.UsersConverter;
import it.contrader.dto.UserDTO;
import it.contrader.service.UsersServiceDTO;


/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi farà User dovrà anche occuparsi del Login che abbiamo lasciato come struttura e va modificata in modo opportuno
 *
 */
public class ManageServletUsers extends HttpServlet {

	private final UsersServiceDTO usersServiceDTO = new UsersServiceDTO();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		final HttpSession session = request.getSession();
		session.setAttribute("posts", null);
		
		if(request != null)
		{
			//System.out.println(usersServiceDTO.getAllUser());
			
			List<UserDTO> usersDTO= usersServiceDTO.getAllUser();
			String tmpUserData="";
			for(UserDTO usr : usersDTO)
			{
				tmpUserData += "<tr>";
				tmpUserData += "<td>" + usr.getUserId() +"</td> <td>" +usr.getName() +"</td> <td>"+usr.getSurname()+"</td> <td>"+usr.getUsername()+"</td> <td>"+usr.getPassword()+"</td> <td>"+usr.isUserState() ;
				tmpUserData += "</tr>";
			}
			session.setAttribute("posts", tmpUserData);
			getServletContext().getRequestDispatcher("/manageUsers.jsp").forward(request, response);
		}
		
	}

}
