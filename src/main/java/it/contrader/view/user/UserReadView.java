package it.contrader.view.user;

import java.util.Scanner;
import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class UserReadView implements View {

	private UserController usersController;
	private Request request;

	public UserReadView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int userIdToRead;

		System.out.println("Insert user's id:");

		try {
			userIdToRead = Integer.parseInt(getInput());
			UserDTO userDB = usersController.readUser(userIdToRead);

			System.out.println("Id: " + userDB.getUserId());
			System.out.println("Username: " + userDB.getUsername());
			System.out.println("User type: " + userDB.getUsertype());
			
			//Wait user to show
			System.out.println("Press key to continue...");
			try {
				getInput();
			} catch (Exception e) {
				
			}

		} catch (Exception e) {
			System.out.println("WRONG VALUE!!!");
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
