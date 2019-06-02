package it.contrader.view.devices;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.dao.UserDAO;
import it.contrader.controller.DevicesController;
import it.contrader.dto.DevicesDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.view.View;


public class DevicesInsertView implements View {
	
	private DevicesController devicesController;
	private Request request ;
	
	public DevicesInsertView() {
		this.devicesController = new DevicesController ();
		
	}
	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String model;
		int user;

		System.out.println("\n---INSERT A DEVICE---");
		System.out.print("\nModel Type: ");
		model = getInput();
		
		System.out.print("User Type : ");
		
		//Il blocco dentro il try esisteva gia ma senza il try catch per gestire l'eccezione dato he noi in input 1
		//vogliamo in inteto però se non passi in itero può presentarsi un eccezionne
		//inserendo nel try nel caso non venga passato un numero entra nel catch e stampa un avviso
		try {
			user = Integer.parseInt(getInput());
			UserDAO userDAO = new UserDAO();
			User userRead = userDAO.readUser(user);
			if (!model.equals("") && !userRead.equals("")) {
				//System.out.println("Sono qui");
				
				DevicesDTO newDevicesDto = new DevicesDTO(model,userRead);
				
				//newUserDto.ShowAttributes();
				
				devicesController.insertDevices(newDevicesDto);
			}
		}catch(Exception e) {
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

