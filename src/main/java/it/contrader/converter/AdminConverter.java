package it.contrader.converter;


import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.DoctorDTO;
import it.contrader.model.Doctor;

public class AdminConverter {

	public static Doctor toEntity(DoctorDTO doctorDTO) {
		Doctor doctor = null;
		if (doctorDTO != null) {
			doctor = new Doctor();
			doctor.setName(doctorDTO.getName());
			doctor.setSurname(doctorDTO.getSurname());
			doctor.setDoctorId(doctorDTO.getDoctorId());
			doctor.setUserName(doctorDTO.getUserName());
			doctor.setUserType(doctorDTO.getUserType());
			doctor.setPassword(doctorDTO.getPassword());
			doctor.setUserState(doctorDTO.isUserState());
		}
		return doctor;
	}
	
	public static List<Doctor> toEntity(List<DoctorDTO> doctorDTO) {

		List<Doctor> doctorList = new ArrayList<>();
		if(doctorDTO != null) {
			for(DoctorDTO doctor: doctorDTO) {
				Doctor tempDoctor = new Doctor();
				tempDoctor.setDoctorId(doctor.getDoctorId());
				tempDoctor.setUserName(doctor.getUserName());
				tempDoctor.setUserType(doctor.getUserType());
				tempDoctor.setName(doctor.getName());
				tempDoctor.setSurname(doctor.getSurname());
				tempDoctor.setPassword(doctor.getPassword());
				tempDoctor.setUserState(doctor.isUserState());
				doctorList.add(tempDoctor);
			}	
		}
		return doctorList;
	}

	public static DoctorDTO toDTO(Doctor doctor) {

		DoctorDTO dcotorDTO = new DoctorDTO();
		if(doctor != null) {
			dcotorDTO.setDoctorId(doctor.getDoctorId());
			dcotorDTO.setUserName(doctor.getUserName());
			dcotorDTO.setUserType(doctor.getUserType());
			dcotorDTO.setName(doctor.getName());
			dcotorDTO.setSurname(doctor.getSurname());
			dcotorDTO.setPassword(doctor.getPassword());
			dcotorDTO.setUserState(doctor.isUserState());
		}
		return dcotorDTO;
	}
	
	public static List<DoctorDTO> toDTO(List<Doctor> doctor) {

		List<DoctorDTO> doctorDTOList = new ArrayList<>();
		if(doctor != null) {
			for(Doctor doctors: doctor) {
				DoctorDTO doctorDTO = new DoctorDTO();
				doctorDTO.setDoctorId(doctors.getDoctorId());
				doctorDTO.setUserName(doctors.getUserName());
				doctorDTO.setUserType(doctors.getUserType());
				doctorDTO.setName(doctors.getName());
				doctorDTO.setSurname(doctors.getSurname());
				doctorDTO.setPassword(doctors.getPassword());
				doctorDTO.setUserState(doctors.isUserState());
				doctorDTOList.add(doctorDTO);
			}
		}
		return doctorDTOList;
	}
	

}
