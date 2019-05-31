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

		System.out.println("Insert dati Paziente:");
		System.out.print("Insert name: ");
		name = getInput();
		
		System.out.print("Insert cognome: ");
		surname = getInput();
		
		System.out.print("Insert l'username: ");
		username = getInput();
		
		System.out.print("Insert password: ");
		password = getInput();
		
		usertype="user";
		
		if (!username.equals("") && !usertype.equals("")) {
		//	System.out.println("Sono qui");
			
			UserDTO newUserDto = new UserDTO(name,surname,username,password,usertype,userState);
			
			//newUserDto.ShowAttributes();
			
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
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}


