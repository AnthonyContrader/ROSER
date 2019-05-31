

package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.DoctorController;
import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;

public class HomeDoctorView implements View{
	
	private String choice;
	private DoctorController doctorController;
	//private Request request;
	
	public HomeDoctorView() {
		this.doctorController = new DoctorController();
	}
	public void showResults(Request request) {
		System.out.println("Welcome in ROSER " + request.get("nomeUtente").toString());
	}
	
	
	public void showOptions() {
		System.out.println("-------DOCTOR MENU-------\n");
		System.out.println("ID\tNome\tCognome\tUsername\tPassword\tTipoUtente\tStato");
		System.out.print("-------------------------------------------------------------------------------");
		List<User> users = doctorController.getAllPatient();
		System.out.println();
		users.forEach(user -> System.out.println(user.toString()));
		System.out.println();
		System.out.println("Make a choice");
		System.out.println("[M]odify -[D]evice Match - [I]nsert Patient - [E]xit");
		this.choice = this.getInput();
		/*request = new Request();
		request.put("choice",choice);
		request.put("mode", "");*/
		
	}
	
	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
			
		if(choice.equalsIgnoreCase("M"))
			MainDispatcher.getInstance().callView("doctor.DoctorUpdate",null);
		
		if(choice.equalsIgnoreCase("I"))
			MainDispatcher.getInstance().callView("doctor.DoctorInsert", null);
		
		if(choice.equalsIgnoreCase("D"))
			MainDispatcher.getInstance().callView("doctor.DoctorMatch", null);
		
		if (choice.equalsIgnoreCase("E"))
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
		
        else {
            Request request = new Request();
            request.put("choice", choice);
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        }
		
	}
}
