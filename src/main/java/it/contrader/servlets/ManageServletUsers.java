package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
			
			String[] tmp = getValuesParameters(request.getParameter("pulsante"));
			String choose = tmp[0]; //memorizzo il nome
			int idUser = Integer.parseInt(tmp[1]);

			switch(choose)
			{
			case "Insert":
				getServletContext().getRequestDispatcher("/insertUser.jsp").forward(request,response);
				break;
				
			case "Delete":
				usersServiceDTO.deleteUser(idUser);
				
				request.getRequestDispatcher("LoginServlet").forward(request,response);
				
				break;
				
			case "Update": //non abbiamo
				getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
				break;
				
			case "Back":
				getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
				break;
			
				
			}
		}
		
	}
	
	
	
	public String[] getValuesParameters(String insert)
	{
		
		String name = "";
		String id = "";
		String[] types = {"Insert","Delete","Update","Back"};
		String[] result = new String[2];
		
		for(int i=0;i<types.length;i++)
		{
			if(insert.contains(types[i]))
			{
				name = types[i];
				id = insert.replace(name, "");
				System.out.println("Valore id: "+id);
				break;
			}
		}
		
		result[0] = name;
		result[1] = id;
		
			
		return result;
	}

}
