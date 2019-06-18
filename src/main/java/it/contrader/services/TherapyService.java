package it.contrader.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterTherapy;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.TherapyRepository;
import it.contrader.dto.TherapyDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Therapy;

@Service
public class TherapyService {

	private final TherapyRepository therapyRepository;

	@Autowired
	public TherapyService(TherapyRepository therapyRepository) {
		this.therapyRepository = therapyRepository;
	}
	
	public List<TherapyDTO> getAllTherapyDTO() {
		return ConverterTherapy.toListDTO((List<Therapy>) therapyRepository.findAll());
	}
	
	public void deleteTherapyById(Integer id) {
		therapyRepository.deleteById(id);
	}
	
	public boolean insertTherapy(TherapyDTO therapyDTO) {
		return therapyRepository.save(ConverterTherapy.toEntity(therapyDTO)) != null;
	}
	
	public boolean updateTherapy(TherapyDTO therapyDTO) {
		return therapyRepository.save(ConverterTherapy.toEntity(therapyDTO)) != null;
	}
	
	public TherapyDTO getTherapyDTOById(Integer id) {
		return ConverterTherapy.toDTO(therapyRepository.findById(id).get());
	}
	
/*	public RobotDTO save(RobotDTO robotDTO) {
		return ConverterRobot.toDTO(robotRepository.save(ConverterRobot.toEntity(robotDTO)));
	}
	
	
	public RobotDTO readRobot(String robotModel) {
		return ConverterRobot.toDTO(this.robotRepository.findRobotByRobotModel(robotModel));
	}
	
	public void disMatchRobot(int idRobot) {
		robotRepository.disMatch(idRobot);
	}


	public UserDTO getByUsernameAndPassword(String username, String password) {

		final User user = userRepository.findUserByUserUserAndUserPass(username, password);

		return ConverterUser.toDTO(user);
	}

	
	public List<UserDTO> findUserDTOByUsername(String username) {
		
		final List<User> list = userRepository.findAllByUserUser(username);
		final List<UserDTO> userDTOs = new ArrayList<>();
		list.forEach(i -> userDTOs.add(ConverterUser.toDTO(i)));
		return userDTOs;
		
	
	}*/
}
