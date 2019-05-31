

package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.DoctorController;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeDoctorView implements View{
	
	private String choice;
	private DoctorController doctoController;
	private Request request;
	
	public void showResults(Request request) {
		System.out.println("Welcome in ROSER " + request.get("nomeUtente").toString());
	}
	
	
	public void showOptions() {
		System.out.println("-------DOCTOR MENU-------\n");
		System.out.println("Make a choice");
		System.out.println("[P]atient - [M]odify - [M]atch - [E]xit");
		this.choice = this.getInput();
		/*request = new Request();
		request.put("choice",choice);
		request.put("mode", "");*/
		if(choice.equalsIgnoreCase("P")){
			MainDispatcher.getInstance().callView("User", null);
		}
	}
	
	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		    MainDispatcher.getInstance().callAction("Devices", "doControl", this.request);
	}
}
