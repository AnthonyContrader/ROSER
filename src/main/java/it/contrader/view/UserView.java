package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;

public class UserView implements View {

	private UserController usersController;
	private Request request;
	private String choice;
	
	public UserView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
	
		System.out.println("\n------USERS MANAGMENT -------\n");
		System.out.println("ID\tName\tSurnme\tUsername\tPassword\tUser Type\tState");
		System.out.print("-------------------------------------------------------------------------------");
		List<User> users = usersController.getAllUser();
		System.out.println();
		users.forEach(user -> System.out.println(user.toString()));
		System.out.println();
		
		System.out.println("Choose an operation:");
		System.out.println("[R]ead - [I]nsert - [U]pdate - [D]elete - [E]xit");
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		    MainDispatcher.getInstance().callAction("User", "doControl", this.request);
	}

}
