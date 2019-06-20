package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.SensordataRepository;
import it.contrader.dto.SensordataDTO;
import it.contrader.model.Sensordata;

@Service
public class SensordataService extends AbstractService<Sensordata,SensordataDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public SensordataDTO findById(int id) {
		return converter.toDTO(((SensordataRepository)repository).findById(id));
	}

}