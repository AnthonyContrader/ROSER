package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DevicesDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Devices;
import it.contrader.model.User;

public class ConverterDevices {
	public static DevicesDTO toDTO(Devices devices) {
		DevicesDTO devicesDTO = null;
		if (devices != null) {
			devicesDTO = new DevicesDTO();
			//userDTO.setUserId(user.getUserId());
			//userDTO.setUsername(user.getUsername());
			//userDTO.setUsertype(user.getUsertype());
			
			devicesDTO.setModel(devices.getModel());
			devicesDTO.setUser(devices.getUser());
			devicesDTO.setDevId(devices.getDevId());
			
		}
		return devicesDTO;
	}
	
	public static Devices toEntity(DevicesDTO devicesDTO) {
		Devices devices = null;
		if (devicesDTO != null) {
			devices = new Devices();
			devices.setModel(devicesDTO.getModel());
			devices.setUser(devicesDTO.getUser());
			devices.setDevId(devicesDTO.getDevId());
		}
		return devices;
	}
	
	public static List<DevicesDTO> toListDTO(List<Devices> list) {
		List<DevicesDTO> listDevicesDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Devices devices : list) {
				listDevicesDTO.add(ConverterDevices.toDTO(devices));
			}
		}
		return listDevicesDTO;
	}
	public static List<Devices> toListEntity(List<DevicesDTO> listDevicesDTO) {
		List<Devices> list = new ArrayList<>();
		if (!listDevicesDTO.isEmpty()) {
			for (DevicesDTO devicesDTO : listDevicesDTO) {
				list.add(ConverterDevices.toEntity(devicesDTO));
			}
		}
		return list;
	}




}
