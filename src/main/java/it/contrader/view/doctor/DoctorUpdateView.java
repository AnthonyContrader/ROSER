package it.contrader.view.doctor;

import java.util.Scanner;

import it.contrader.controller.DoctorController;
import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.view.View;

public class DoctorUpdateView implements View {
	
	private DoctorController doctorController;
	private Request request;
	
	public DoctorUpdateView() {
		this.doctorController = new DoctorController();
	}
	
	@Override
	public void showResults(Request request) {
	}
	
	@Override
	public void showOptions() {
		String username, usertype, name, surname, password, userState;
		int userIdToUpdate;
		User user;
		
		
		//System.out.println("\n----- Seleziona l'utente da modificate  -----\n");
		// System.out.println();
		// users.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		UserDTO userDTO = new UserDTO();

		System.out.print("Digita l'Id dell'utente da modificare:");
		try {
			userIdToUpdate = Integer.parseInt(getInput());
			if (userIdToUpdate != 0) {
				userDTO.setUserId(userIdToUpdate);
				
				System.out.println("Cosa vuoi modificare?");
				System.out.println(" 1) Nome");
				System.out.println(" 2) Cognome");
				System.out.println(" 3) Username");
				System.out.println(" 4) Password");
				System.out.println(" 5) Tipo di utente");
				System.out.println(" 6) Esci");
				
				String scelta =	getInput();
				
				
				switch(scelta)
				{
					case "1": 
						System.out.print("Insert Name: ");
						name= getInput();
						if (!name.equals(""))
							userDTO.setName(name);
						break;
						
					case "2": 
						System.out.print("Insert Surname: ");
						surname= getInput();
						if (!surname.equals(""))
							userDTO.setSurname(surname);
						break;
						
					case "3": 
						System.out.print("Insert Username: ");
						username= getInput();
						if (!username.equals(""))
							userDTO.setUsername(username);
						break;
					
					case "4":
						System.out.print("Insert Password: ");
						password = getInput();
						if (!password.equals(""))
							userDTO.setPassword(password);
						break;
						
					
					case "5":
						break;
						
					default: System.out.println("");
				}
				
				doctorController.updateUser(userDTO);

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
		MainDispatcher.getInstance().callAction("Doctor", "doControl", request);
	}
	


}
