package it.contrader.view.doctor;

import java.util.Scanner;

import it.contrader.controller.DoctorController;
import it.contrader.controller.Request;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class DoctorInsertView implements View {

	private DoctorController doctorController;
	private Request request;

	public DoctorInsertView() {
		this.doctorController = new DoctorController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String username, usertype, name, surname, password;
		boolean userState = false;

		System.out.println("INSERT PATIENT'S FIELDS");
		System.out.print("\nInsert name: ");
		name = getInput();
		
		System.out.print("Insert Surname: ");
		surname = getInput();
		
		System.out.print("Insert Username: ");
		username = getInput();
		
		System.out.print("Insert Password: ");
		password = getInput();
		
		usertype="user";
		userState = true;
		
		if (!username.equals("") && !usertype.equals("")) 
		{
			UserDTO newUserDto = new UserDTO(name,surname,username,password,usertype,userState);
			doctorController.insertUser(newUserDto);
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


