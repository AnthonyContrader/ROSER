package it.contrader.controller;

import it.contrader.dto.DevicesDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Devices;
import it.contrader.service.DevicesService;

import java.util.List;

public class DevicesController implements Controller{
	
	private static String sub_package = "devices."; 
	private DevicesService devicesService;
	private Request request;
	
	public DevicesController() {
		this.devicesService = new DevicesService();
	}

	public List<Devices> getAllDevices(){
		return this.devicesService.getAllDevices();
	}

	public DevicesDTO readDevices(int devicesId) {
		return this.devicesService.readDevices(devicesId);
	}

	public boolean insertDevices(DevicesDTO devicesDTO) {
		return this.devicesService.insertDevices(devicesDTO);
	}

	public boolean updateDevices(DevicesDTO devicesDTO) {
		return this.devicesService.updateDevices(devicesDTO);
	}

	public boolean deleteDevices(int devicesId) {
		return this.devicesService.deleteDevices(devicesId);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("User", null);
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
		}
	}
}
