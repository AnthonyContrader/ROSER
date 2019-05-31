package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.DoctorDTO;
import it.contrader.model.Doctor;

public class ConverterDoctor 
{
	public static DoctorDTO toDTO(Doctor doctor)
	{
		DoctorDTO doctorDTO = null;
		if(doctor != null)
		{
			doctorDTO = new DoctorDTO();
			doctorDTO.setName(doctor.getName());
			doctorDTO.setSurname(doctor.getSurname());
			doctorDTO.setUserId(doctor.getUserId());
			doctorDTO.setUsername(doctor.getUsername());
			doctorDTO.setPassword(doctor.getPassword());
			doctorDTO.setUserState(doctor.isUserState());
			
		}
		
		return doctorDTO;
	}
	
	
	public static Doctor toEntity(DoctorDTO doctorDTO)
	{
		Doctor doctor = null;
		if(doctorDTO != null)
		{
			doctor = new Doctor();
			doctor.setName(doctorDTO.getName());
			doctor.setSurname(doctorDTO.getSurname());
			doctor.setUserId(doctorDTO.getUserId());
			doctor.setUsername(doctorDTO.getUsername());
			doctor.setPassword(doctorDTO.getPassword());
			doctor.setUserState(doctorDTO.isUserState());
			
		}
		
		return doctor;
	}
	
	public static List<DoctorDTO> toListDTO(List<Doctor> list)
	{
		List<DoctorDTO> listDoctorDTO = new ArrayList<>();
		if(!list.isEmpty())
		{
			for(Doctor doctor : list)
			{
				listDoctorDTO.add(ConverterDoctor.toDTO(doctor));
			}
		}
		
		return listDoctorDTO;
	}
	
	public static List<Doctor> toListEntity(List<DoctorDTO> listDoctorDTO)
	{
		List<Doctor> list = new ArrayList<>();
		if (!listDoctorDTO.isEmpty()) {
			for (DoctorDTO doctorDTO : listDoctorDTO) {
				list.add(ConverterDoctor.toEntity(doctorDTO));
			}
		}
		return list;
	}
	
	

}
