package it.contrader.view.user;

import java.util.List;
import java.util.Scanner;
import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.view.View;

public class UserUpdateView implements View {

	private UserController usersController;
	private Request request;

	public UserUpdateView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int userIdToUpdate;
		String username, usertype, name, surname, password;
		
		//System.out.println("\n----- Seleziona l'utente da modificate  -----\n");
		// System.out.println();
		// users.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		UserDTO userDTO = new UserDTO();
		

		System.out.print("\nINSERT USER'S ID:");
		try {
			userIdToUpdate = Integer.parseInt(getInput());
			if (userIdToUpdate != 0) {
				userDTO.setUserId(userIdToUpdate);
				
				System.out.println("What do you want to change?\n");
				System.out.println(" 1) Name");
				System.out.println(" 2) Surname");
				System.out.println(" 3) Username");
				System.out.println(" 4) Password");
				System.out.println(" 5) Enable/Disable User Account");
				System.out.println(" 6) Esci");
				
				String scelta =	getInput();
				
				UserDAO userRead = new UserDAO();       /* MODIFICA: Aggiunti per determinare o stato del'utente */
				User user = userRead.readUser(userIdToUpdate);
				switch(scelta)
				{
					case "1": 
						System.out.print("Insert Name: ");
						name= getInput();
						if (!name.equals("")) {
							userDTO.setName(name);
							
						}
						//MODIFICA: Controlla lo stato dell'utente e lo setta di conseguenza(da mettere in ogni case)
						if(user.isUserState()) {
							userDTO.setUserState(true);
						}else {
							userDTO.setUserState(false);
						}
						break;
						
					case "2": 
						System.out.print("Insert Surname: ");
						surname= getInput();
						if (!surname.equals("")) {
							userDTO.setSurname(surname);
						}
						if(user.isUserState()) {
							userDTO.setUserState(true);
						}else {
							userDTO.setUserState(false);
						}
						break;
						
					case "3": 
						System.out.print("Insert Username: ");
						username= getInput();
						if (!username.equals("")) {
							userDTO.setUsername(username);
						}
						if(user.isUserState()) {
							userDTO.setUserState(true);
						}else {
							userDTO.setUserState(false);
						}
						break;
					
					case "4":
						System.out.print("Insert Password: ");
						password = getInput();
						if (!password.equals("")) {
							userDTO.setPassword(password);
						}
						if(user.isUserState()) {
							userDTO.setUserState(true);
						}else {
							userDTO.setUserState(false);
						}
						break;
						
					case "5": 

						int userReturnValue = accountStateUsers(userIdToUpdate);
						if(userReturnValue == 1)
						{
							userDTO.setUserState(false);
							getInput();
						}
						else if(userReturnValue == 2)
						{
							userDTO.setUserState(true);
							getInput();
						}
						
						break;
						
					case "6":
						break;
						
					default: System.out.println("");
				}
				
				usersController.updateUser(userDTO);

			}
		} catch (Exception e) {
			System.out.println("WRONG VALUE!!");
		}

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}
	
	public int accountStateUsers(int id)
	{
		
		 List<User> users = usersController.getAllUser();
		 
		for (User gen : users) 
		{
			if (gen.getUserId() == id)
			{
			//	System.out.println("Valore :"+gen.isUserState());
				
				if(gen.isUserState())
				{
					System.out.println("Account user is Disabled!");
					gen.setUserState(false);
					return 1;
							
				}
				
				if(!gen.isUserState())
				{
					System.out.println("Account user is Enabled!");
					gen.setUserState(true);
				return 2;
				}
				
			}	
				
		}
		
		return 3;
		
	}

}
