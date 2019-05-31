package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.PatientController;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class PatientView implements View
{
	private PatientController patientController;
	private Request request;
	private String choice;
	
	public PatientView() 
	{
		this.patientController = new PatientController();
	}
		

	@Override
	public void showResults(Request request) {
		System.out.println("Benvenuto in ROSER "+request.get("nomeUtente").toString());
	}

	@Override
	public void showOptions() {
		System.out.println("..................................................");
		System.out.println("NON CI SONO ANCORA FUNZIONALITA");
		System.out.println("'..................................................'");
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[E]sci");
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
