package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterSensordata;
import it.contrader.dao.SensordataRepository;
import it.contrader.dto.SensordataDTO;
import it.contrader.model.Sensordata;

@Service
public class SensordataService {

	private final SensordataRepository sensordataRepository;

	@Autowired
	public SensordataService(SensordataRepository sensordataRepository) {
		this.sensordataRepository = sensordataRepository;
	}
	
/*	public List<UserDTO> getListaUserDTO() {
		return ConverterUser.toListDTO((List<User>) userRepository.findAll());
	}

	public UserDTO getUserDTOById(Integer id) {
		return ConverterUser.toDTO(userRepository.findById(id).get());
	}

	public UserDTO getByUsernameAndPassword(String username, String password) {

		final User user = userRepository.findUserByUserUserAndUserPass(username, password);

		return ConverterUser.toDTO(user);
	}
*/
	public boolean insertData(SensordataDTO sensordataDTO) {
		return sensordataRepository.save(ConverterSensordata.toEntity(sensordataDTO)) != null;
	}

/*	public boolean updateUser(UserDTO userDTO) {
		return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	}
*/	
	public void deleteDataById(Integer id) {
		sensordataRepository.deleteById(id);
	}
		
	public List<SensordataDTO> findDataByRobotModel(String robotModel) {
		
		final List<SensordataDTO> list = ConverterSensordata.toListDTO(sensordataRepository.findDataByRobotModel(robotModel));
		//final List<SensordataDTO> sensordataDTOs = new ArrayList<>();
		//list.forEach(i -> sensordataDTOs.add(ConverterSensordata.toDTO(i)));
		return list;
		
	
	}

}

