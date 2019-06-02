package it.contrader.view.devices;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import it.contrader.controller.Request;
import it.contrader.dao.UserDAO;
import it.contrader.controller.DevicesController;
import it.contrader.dto.DevicesDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Devices;
import it.contrader.model.User;
import it.contrader.view.View;

public class DevicesUpdateView  implements View {

		private DevicesController devicesController;
		private Request request;

		public DevicesUpdateView() {
			this.devicesController = new DevicesController();
		}

		@Override
		public void showResults(Request request) {
		}

		@Override
		public void showOptions() {
			int deviceIdToUpdate;
			String  userId, modelName;
			DevicesDTO deviceDTO = new DevicesDTO();

			System.out.print("Insert the device's ID: ");
			try {
				deviceIdToUpdate = Integer.parseInt(getInput());
				if (deviceIdToUpdate != 0) {
					deviceDTO.setDevId(deviceIdToUpdate);
					
					System.out.println("What do you want to change?");
					System.out.println(" 1) Model");
					System.out.println(" 2) Owner");
					System.out.println(" 3) Exit");
					
					String scelta =	getInput().trim();
					
					
					switch(scelta)
					{
						case "1": 
							System.out.print("Insert Model Name: ");
							modelName= getInput();
							if (!modelName.equals(""))
								deviceDTO.setModel(modelName);
							break;
						
						case "2": 
							System.out.print("Insert Owner: ");
							userId = getInput();
							UserDAO readUser = new UserDAO();
							User oldUser = readUser.readUser(Integer.parseInt(userId));
							deviceDTO.setUser(oldUser);
							break;
							
						case "3":
							break;
							
							
						default:
							System.out.println("");
							break;
					}
					
					devicesController.updateDevices(deviceDTO);

				}
			} catch (Exception e) {
				System.out.println("WRONG VALUE!!!");
				e.printStackTrace();
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

