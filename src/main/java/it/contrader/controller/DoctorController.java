//package it.contrader.controller;

//public class DoctorController {

//}

package it.contrader.controller;

import java.util.List;

import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Devices;
import it.contrader.model.User;
import it.contrader.service.DoctorService;
import it.contrader.service.UserService;

public class DoctorController implements Controller {

	private static String sub_package = "doctor.";
	private DoctorService doctorService;
	private Request request;

	public DoctorController() {
		this.doctorService = new DoctorService();
	}

	public List<User> getAllUser() {
		return this.doctorService.getAllUser();
	}

	public UserDTO readUser(int userId) {
		return this.doctorService.readUser(userId);
	}

	public boolean insertUser(UserDTO usersDTO) {
		return this.doctorService.insertUser(usersDTO);
	}

	public boolean updateUser(UserDTO usersDTO) {
		return this.doctorService.updateUser(usersDTO);
	}

	public boolean deleteUser(Integer usersId) {
		return this.doctorService.deleteUser(usersId);
	}
	
	public boolean matchDevices(User user, Devices device) {
		return this.doctorService.matchDevices(user,device);
	}
	
	public boolean dismatchDevices(User user, Devices device) {
		return this.doctorService.dismatchDevices(user,device);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("DoctorUser", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "DoctorRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "DoctorInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "DoctorUpdate", null);
				break;
			case "D":
				MainDispatcher.getInstance().callView(sub_package + "DoctorDelete", null);
				break;
			case "A":
				MainDispatcher.getInstance().callView(sub_package + "MatchDevice", null);
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