package it.contrader.view.doctor;

import java.util.Scanner;

import it.contrader.controller.DoctorController;
import it.contrader.controller.Request;
import it.contrader.dao.DevicesDAO;
import it.contrader.dao.UserDAO;
import it.contrader.dto.DevicesDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Devices;
import it.contrader.model.User;
import it.contrader.view.View;

public class DoctorMatchView implements View{
	private DoctorController doctorController;
	private Request request;
	
	public DoctorMatchView() {
		this.doctorController = new DoctorController();
	}
	
	@Override
	public void showResults(Request request) {
		
	}
	
	@Override
	public void showOptions() {
		User user = null;
		Devices device = null;
		
		UserDTO userDTO = new UserDTO();
		UserDAO userRead = new UserDAO();
		DevicesDTO deviceDTO = new DevicesDTO();
		DevicesDAO deviceRead = new DevicesDAO();
		try {
			System.out.println("Make a choice:\n1)Match\n2)Unmatch");
			String choice = getInput();
			int userId;
			int idDevice;
			switch(choice) {
				case "1":
					System.out.println("Type id of devices");
					idDevice = Integer.parseInt(getInput());
					device = deviceRead.readDevices(idDevice);
		
					System.out.println("Type id of patient");
					userId = Integer.parseInt(getInput());
					user = userRead.readUser(userId);
					break;
				case "2":
					System.out.println("Type id of devices");
					idDevice = Integer.parseInt(getInput());
					device = deviceRead.readDevices(idDevice);
		
					System.out.println("Type id of patient");
					userId = Integer.parseInt(getInput());
					user = userRead.readUser(userId);
					break;
			}
			doctorController.dismatchDevices(user,device);
		}catch(Exception e) {
			System.out.println("Hai inserito un valore errato");
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
