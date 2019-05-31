package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterDoctor;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.DoctorDAO;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Devices;
import it.contrader.model.User;

public class DoctorService {
	
	private DoctorDAO doctorDAO;
	
	public DoctorService() {
		this.doctorDAO = new DoctorDAO();
	}
	
	public List<User> getAllUser() {
		return this.doctorDAO.getAllPatient();
	}
	
	public boolean insertUser(UserDTO userDTO) {
		return this.doctorDAO.insertUser(ConverterUser.toEntity(userDTO));
	}
	
	public UserDTO readUser(int userId) {
		return ConverterDoctor.toDTO(this.doctorDAO.readUser(userId));
	}
	
	public boolean updateUser(UserDTO userDTO) {
		return this.doctorDAO.updateUser(ConverterUser.toEntity(userDTO));
	}
	
	public boolean deleteUser(int userId) {
		return this.doctorDAO.deleteUser(userId);
	}
	
	public boolean matchDevices(User user, Devices device) {
		return this.doctorDAO.matchDevices(user,device);
	}
	
	public boolean dismatchDevices(User user, Devices device) {
		return this.doctorDAO.matchDevices(user,device);
	}
}
