package it.contrader.dao;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Sensordata;


@Repository
@Transactional
public interface SensordataRepository extends CrudRepository<Sensordata, Long>{

	Sensordata findById(int id);
	
}


