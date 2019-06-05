package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DoctorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Doctor;
import it.contrader.model.Doctor;


public class DoctorConverter {
	
	public static Doctor toEntity(DoctorDTO doctorDTO) {

		Doctor doctor = null;
		if (doctorDTO != null) {
			doctor = new Doctor();
			doctor.setName(doctorDTO.getName());
			doctor.setSurname(doctorDTO.getSurname());
			doctor.setDoctorId(doctorDTO.getDoctorId());
			doctor.setUsername(doctorDTO.getUsername());
			doctor.setUsertype(doctorDTO.getUsertype());
			doctor.setPassword(doctorDTO.getPassword());
			doctor.setUserState(doctorDTO.isUserState());
		}
		return doctor;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */
	public static DoctorDTO toDTO(Doctor doctor) {

		DoctorDTO doctorDTO = null;
		if (doctor != null) {
			doctorDTO = new DoctorDTO();
			//userDTO.setUserId(user.getUserId());
			//userDTO.setUsername(user.getUsername());
			//userDTO.setUsertype(user.getUsertype());
			
			doctorDTO.setName(doctor.getName());
			doctorDTO.setSurname(doctor.getSurname());
			doctorDTO.setDoctorId(doctor.getDoctorId());
			doctorDTO.setUsername(doctor.getUsername());
			doctorDTO.setUsertype(doctor.getUsertype()); //da togliere
			doctorDTO.setPassword(doctor.getPassword());
			doctorDTO.setUserState(doctor.isUserState());
		}
		return doctorDTO;
	}
	


}
