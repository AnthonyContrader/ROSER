package it.contrader.converter;


import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.DoctorDTO;
import it.contrader.dto.RobotDTO;
import it.contrader.model.Doctor;
import it.contrader.model.Robot;

public class AdminConverter {

	public static Doctor toEntity(DoctorDTO doctorDTO) {
		Doctor doctor = new Doctor();
		if (doctorDTO != null) {
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
	
	public static Robot robotToEntity(RobotDTO robotDTO)
	{
		Robot robot = new Robot();
		if(robotDTO != null)
		{
			robot.setRobotId(robotDTO.getRobotId());
			robot.setRobotModel(robotDTO.getRobotModel());
			robot.setRobotOwnerName(robotDTO.getRobotOwnerName());
			robot.setRobotOwnerSurname(robotDTO.getRobotOwnerSurname());
			robot.setUsername(robotDTO.getRobotUsername());
			robot.setRobotPassword(robotDTO.getRobotPassword());	
			robot.setName(robotDTO.getName());
			robot.setType(robotDTO.getType());
			robot.setSurname(robotDTO.getSurname());
		}
		return robot;
		
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
	public static List<Robot> robotToEntity(List<RobotDTO> robotDTO)
	{
		List<Robot> robotList = new ArrayList<>();
		if(robotDTO != null)
		{
			for(RobotDTO robot : robotDTO)
			{
				Robot tmpRobot = new Robot();
				tmpRobot.setRobotId(robot.getRobotId());
				tmpRobot.setRobotModel(robot.getRobotModel());
				tmpRobot.setRobotOwnerName(robot.getRobotOwnerName());
				tmpRobot.setRobotOwnerSurname(robot.getRobotOwnerSurname());
				tmpRobot.setUsername(robot.getRobotUsername());
				tmpRobot.setRobotPassword(robot.getRobotPassword());
				tmpRobot.setName(robot.getName());
				tmpRobot.setType(robot.getType());
				robotList.add(tmpRobot);
			}
		}
		
		return robotList;
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
	
	public static RobotDTO robotToDTO(Robot robot) {

		RobotDTO robotDTO = new RobotDTO();
		if(robot != null) {
			/*
			 * */
			robotDTO.setRobotId(robot.getRobotId());
			robotDTO.setUsername(robot.getUsername());
			robotDTO.setType(robot.getType());
			robotDTO.setName(robot.getName());
			robotDTO.setSurname(robot.getSurname());
			robotDTO.setPassword(robot.getPassword());
			robotDTO.setState(robot.isState());
			robotDTO.setRobotOwnerName(robot.getRobotOwnerName());
			robotDTO.setRobotOwnerSurname(robot.getRobotOwnerSurname());
		}
		return robotDTO;
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
	
	public static List<RobotDTO> robotToDTO(List<Robot> robot)
	{
		List<RobotDTO> robotDTOList = new ArrayList<>();
		if(robot != null)
		{
			for(Robot robots : robot)
			{
				
				//int robotId, String robotModel,String ownerName, String ownerSurname, String username, String password)
				RobotDTO robotDTO = new RobotDTO();
				robotDTO.setRobotId(robots.getRobotId());
				robotDTO.setRobotModel(robots.getRobotModel());
				robotDTO.setRobotOwnerName(robots.getRobotOwnerName());
				robotDTO.setRobotOwnerSurname(robots.getRobotOwnerSurname());
				robotDTO.setRobotUsername(robots.getUsername());
				robotDTO.setRobotPassword(robots.getPassword());
				robotDTOList.add(robotDTO);
				
			}
		}
		return robotDTOList;
	}

}
