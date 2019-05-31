package it.contrader.view.doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.contrader.controller.DoctorController;
import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.view.View;

public class DoctorReadView implements View {
	
	private DoctorController doctorController;
	private Request request;
	
	public DoctorReadView() {
		this.doctorController = new DoctorController();
	}
	
	@Override
	public void showResults(Request request) {
	}
	
	@Override
	public void showOptions() {
		int doctorIdToRead;

		System.out.println("Inserisci l'ID dell'utente:");

		try {
			doctorIdToRead = Integer.parseInt(getInput());
			UserDTO doctorDB = doctorController.readUser(doctorIdToRead);

			System.out.println("Id: " + doctorDB.getUserId());
			System.out.println("Username: " + doctorDB.getUsername());
			
			//Wait user to show
			System.out.println("Premi un tasto per continuare");
			try {
				getInput();
			} catch (Exception e) {
				
			}

		} catch (Exception e) {
			System.out.println("Valore inserito errato.");
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
