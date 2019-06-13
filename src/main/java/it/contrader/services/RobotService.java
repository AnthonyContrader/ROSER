package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterRobot;
import it.contrader.dao.RobotRepository;
import it.contrader.dto.RobotDTO;
import it.contrader.model.Robot;

@Service
public class RobotService {

	private final RobotRepository robotRepository;

	@Autowired
	public RobotService(RobotRepository robotRepository) {
		this.robotRepository = robotRepository;
	}
	
	/*public List<RobotDTO> getListaRobotDTO() {
		return ConverterRobot.toListDTO((List<Robot>) robotRepository.findAll());
	}*/
	
	public RobotDTO readRobot(String robotModel) {
		return ConverterRobot.toDTO(this.robotRepository.findRobotByRobotModel(robotModel));
	}

	/*public UserDTO getUserDTOById(Integer id) {
		return ConverterUser.toDTO(userRepository.findById(id).get());
	}

	public UserDTO getByUsernameAndPassword(String username, String password) {

		final User user = userRepository.findUserByUserUserAndUserPass(username, password);

		return ConverterUser.toDTO(user);
	}

	public boolean insertUser(UserDTO userDTO) {
		return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	}

	public boolean updateUser(UserDTO userDTO) {
		return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	}
	
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}
	
	public List<UserDTO> findUserDTOByUsername(String username) {
		
		final List<User> list = userRepository.findAllByUserUser(username);
		final List<UserDTO> userDTOs = new ArrayList<>();
		list.forEach(i -> userDTOs.add(ConverterUser.toDTO(i)));
		return userDTOs;
		
	
	}*/
}

