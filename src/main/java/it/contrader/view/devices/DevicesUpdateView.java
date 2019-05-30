package it.contrader.view.devices;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import it.contrader.controller.Request;
import it.contrader.controller.DevicesController;
import it.contrader.dto.DevicesDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Devices;
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
			String  owner, modelName;
			
			//System.out.println("\n----- Seleziona l'utente da modificate  -----\n");
			// System.out.println();
			// users.forEach(us_type -> System.out.println(us_type.toString()));
			// System.out.println();
			DevicesDTO deviceDTO = new DevicesDTO();

			System.out.print("Insert the devices ID to update: ");
			try {
				deviceIdToUpdate = Integer.parseInt(getInput());
				if (deviceIdToUpdate != 0) {
					deviceDTO.setDevId(deviceIdToUpdate);
					
					System.out.println("Cosa vuoi modificare?");
					System.out.println(" 1) Model");
					System.out.println(" 2) Owner");
					System.out.println(" 3) Exit");
					
					String scelta =	getInput();
					
					
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
							owner= getInput();
							if (!owner.equals(""))
								//deviceDTO.(owner);
							break;
							
						case "3": 
							break;
							
						default: System.out.println("");
					}
					
					devicesController.updateDevices(deviceDTO);

				}
			} catch (Exception e) {
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
			MainDispatcher.getInstance().callAction("Device", "doControl", request);
		}
		
	/*	public int accountStateUsers(int id)
		{
			
			 List<User> users = usersController.getAllUser();
			 
			for (User gen : users) 
			{
				if (gen.getUserId() == id)
				{
					System.out.println("Valore :"+gen.isUserState());
					
					if(gen.isUserState())
					{
						System.out.println("Account user is Disabled!");
						gen.setUserState(false);
						return 1;
								
					}
					
					if(!gen.isUserState())
					{
						System.out.println("Account user is Enabled!");
						gen.setUserState(true);
					return 2;
					}
					
				}	
					
			}
			
			return 3;
			
		}
*/
	}

