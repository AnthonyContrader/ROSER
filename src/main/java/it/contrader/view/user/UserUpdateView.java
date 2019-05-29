package it.contrader.view.user;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
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
		String username, usertype, name, surname, password, state;

		/*
		 * List<User> users; Integer usersId; String password; users =
		 * usersController.getAllUsers();
		 */
		System.out.println("\n----- Seleziona l'utente da modificate  -----\n");
		// System.out.println();
		// users.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		UserDTO userDTO = new UserDTO();

		System.out.println("Digita l'Id dell'utente da modificare:");
		try {
			userIdToUpdate = Integer.parseInt(getInput());
			if (userIdToUpdate != 0) {
				userDTO.setUserId(userIdToUpdate);
				
				System.out.println("Cosa vuoi modificare?");
				System.out.println(" 1) Nome");
				System.out.println(" 2) Cognome");
				System.out.println(" 3) Username");
				System.out.println(" 4) Password");
				System.out.println(" 5) Tipo");
				System.out.println(" 6) Stato");
				System.out.println(" 7) Esci");
				
				String scelta =	getInput();
				
				
				switch(scelta)
				{
					case "1": 
						System.out.println("Digita nome: ");
						name= getInput();
						if (!name.equals(""))
							userDTO.setName(name);
						break;
						
					case "2": 
						System.out.println("Digita cognome: ");
						surname= getInput();
						if (!surname.equals(""))
							userDTO.setUsername(surname);
						break;
						
					case "3": 
						System.out.println("Digita username: ");
						username= getInput();
						if (!username.equals(""))
							userDTO.setUsername(username);
						break;
					
					case "4":
						System.out.println("Digita password: ");
						password = getInput();
						if (!password.equals(""))
							userDTO.setUsername(password);
						break;
						
					case "5":
						System.out.println("Digita tipo di utente: ");
						usertype = getInput();
						if (!usertype.equals(""))
							userDTO.setUsername(usertype);
						break;
						
					case "6": 
						System.out.println("Digita stato utente ");
						state = getInput();
						if (!state.equals(""))
							userDTO.setUsername(state);
						break;
						
					case "7":
						break;
						
					default: System.out.println("");
				}
				
				//System.out.println("Digita la nuova username:");
				//username = getInput();
				//if (!username.equals(""))
					//userDTO.setUsername(username);

				usersController.updateUser(userDTO);

			}
		} catch (Exception e) {
			System.out.println("Hai inserito un valore errato");
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

}
