package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterDevices;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.DevicesDAO;
import it.contrader.dto.DevicesDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Devices;

public class DevicesService {
	
	private DevicesDAO devicesDAO;
	
	public DevicesService() {
		this.devicesDAO = new DevicesDAO();
	}
	
	public List<Devices> getAllDevices(){
		return this.devicesDAO.getAllDevices();
	}

	public boolean insertDevices(DevicesDTO devicesDTO) {
		return this.devicesDAO.insertDevices(ConverterDevices.toEntity(devicesDTO));
	}

	public DevicesDTO readDevices(int devicesId) {
		return ConverterDevices.toDTO(this.devicesDAO.readDevices(devicesId));
	}

	public boolean updateDevices(DevicesDTO devicesDTO) {
		return this.devicesDAO.updateDevices(ConverterDevices.toEntity(devicesDTO));
	}

	public boolean deleteDevices(int devicesId) {
		return this.devicesDAO.deleteDevices(devicesId);
	}
}
