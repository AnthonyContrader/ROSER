package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.RobotRepository;
import it.contrader.dto.RobotDTO;
import it.contrader.model.Robot;

/**
 * Estende AbstractService con parametri Device e DeviceDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class RobotService extends AbstractService<Robot,RobotDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public RobotDTO findById(int id) {
		return converter.toDTO(((RobotRepository)repository).findById(id));
	}
	public RobotDTO findByModel (String x) {
		return converter.toDTO(((RobotRepository)repository).findByModel(x));
	}

}