package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.TherapyRepository;
import it.contrader.dto.TherapyDTO;
import it.contrader.model.Therapy;

@Service
public class TherapyService extends AbstractService<Therapy,TherapyDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public TherapyDTO findById(int id) {
		return converter.toDTO(((TherapyRepository)repository).findById(id));
	}

}