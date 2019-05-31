package it.contrader.controller;

import it.contrader.main.MainDispatcher;
import it.contrader.service.PatientService;

public class PatientController implements Controller
{
	private static String sub_package = "patient.";
	private PatientService patientService;
	
	public PatientController()
	{
		this.patientService = new PatientService();
	}
	
	
	@Override
	public void doControl(Request request) 
	{
		
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		if(choice == "E")
			MainDispatcher.getInstance().callView("Login", null);
			
	 /*	String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Devices", null);
		} else {
			switch (choice.toUpperCase()) {
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "DevicesInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "DevicesUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "DevicesDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}*/
	}
}
