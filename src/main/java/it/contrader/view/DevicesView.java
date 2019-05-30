package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.DevicesController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Devices;
import it.contrader.model.User;

public class DevicesView implements View{
	
	private DevicesController devicesController;
	private Request request;
	private String choice;
	
	public DevicesView() {
		this.devicesController = new DevicesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Gestione dispositivi -------\n");
		
		System.out.println("ID\tModel\tUser");
		System.out.print("------------------------------------------------------");
		List<Devices> devices = devicesController.getAllDevices();
		System.out.println();
		devices.forEach(device -> System.out.println(device));
		System.out.println();
		
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[I]nserisci [M]odifica [C]ancella [E]sci");
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
		    MainDispatcher.getInstance().callAction("Devices", "doControl", this.request);
	}
}
