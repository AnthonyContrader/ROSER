package it.contrader.view.devices;

import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.DevicesController;
import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class DevicesDeleteView implements View{
	
	private DevicesController devicesController;
	private Request request;
	
	public DevicesDeleteView() {
		this.devicesController = new DevicesController();
	}
	
	@Override
	public void showResults(Request request) {
	}
	
	@Override
	public void showOptions() {
		System.out.print("Insert device's id: ");
		String devicesId = getInput();

		if (devicesId != null && StringUtils.isStrictlyNumeric(devicesId)) {
			devicesController.deleteDevices(Integer.parseInt(devicesId));
			
		} else {
			System.out.println("WRONG VALUE!!!");
		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Devices", "doControl", request);
	}
}
