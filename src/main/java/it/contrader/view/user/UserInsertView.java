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

		System.out.println("\nINSERT USER'S FIELDS");
		System.out.print("\nInsert Name: ");
		name = getInput();
		
		System.out.print("Insert Surname: ");
		surname = getInput();
		
		System.out.print("Insert Username: ");
		username = getInput();
		
		System.out.print("Insert Password: ");
		password = getInput();
		
		usertype="doctor";
		userState = true;
		
		if (!username.equals("") && !usertype.equals("")) {

			UserDTO newUserDto = new UserDTO(name,surname,username,password,usertype,userState);
			
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
