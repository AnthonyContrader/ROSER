package it.contrader.view.user;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class UserInsertView implements View {

	private UserController usersController;
	private Request request;

	public UserInsertView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String username, usertype, name, surname, password;
		boolean userState = false;

		System.out.println("INSERT USER'S FIELDS");
		System.out.print("\nInsert name: ");
		name = getInput();
		
		System.out.print("Insert surname: ");
		surname = getInput();
		
		System.out.print("Insert username: ");
		username = getInput();
		
		System.out.print("Insert password: ");
		password = getInput();
		
	//	System.out.println("Inserisci la tipologia utente");
		usertype="doctor";
		userState = true;
		
		//System.out.println("Inserisci stato utente: ");
		//userState = getInput();
		
		if (!username.equals("") && !usertype.equals("")) {
		//	System.out.println("Sono qui");
			
			UserDTO newUserDto = new UserDTO(name,surname,username,password,usertype,userState);
			
			//newUserDto.ShowAttributes();
			
			usersController.insertUser(newUserDto);
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
