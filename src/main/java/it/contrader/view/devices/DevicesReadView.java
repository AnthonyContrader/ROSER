package it.contrader.view.devices;

import it.contrader.controller.Request;
import it.contrader.dto.DevicesDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

import java.util.Scanner;

import it.contrader.controller.DevicesController;

public class DevicesReadView implements View{
	private DevicesController devicesController;
	private Request request;
	
	public DevicesReadView() {
		this.devicesController = new DevicesController();
	}
	
	@Override
	public void showResults(Request request) {
	}
	
	@Override
	public void showOptions() {
		int devicesIdToRead;
		
		System.out.println("Insert devices ID to remove");
		try {
			devicesIdToRead = Integer.parseInt(getInput());
			DevicesDTO devicesDB = devicesController.readDevices(devicesIdToRead);

			System.out.println("Id: " + devicesDB.getDevId());
			System.out.println("Model: " + devicesDB.getModel());
			System.out.println("User: " + devicesDB.getUser().getUsername());
			
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
		MainDispatcher.getInstance().callAction("Devices", "doControl", request);
	}
}
