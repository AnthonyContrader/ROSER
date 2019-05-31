package it.contrader.view.doctor;

import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.DoctorController;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class DoctorDeleteView implements View {
	
	private DoctorController doctorController;
	private Request request;
	
	public DoctorDeleteView() {
		this.doctorController = new DoctorController();
	}
	@Override
	public void showResults(Request request) {
	}
	@Override
	public void showOptions() {
		//List<User> users;
		//String usersId;

		//users = userController.getAllUser();
		System.out.println("Seleziona il paziente da cancellare: ");
		//System.out.println();
		//user.forEach(user -> System.out.println(user));
		//System.out.println();
		//System.out.println("Digita l'ID:");
		String doctorId = getInput();

		if (doctorId != null && StringUtils.isStrictlyNumeric(doctorId)) {
			doctorController.deleteUser(Integer.parseInt(doctorId));
			
		} else {
			System.out.println("Valore inserito errato");
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
			MainDispatcher.getInstance().callAction("User", "doControl", request);
		}

	
	
}

