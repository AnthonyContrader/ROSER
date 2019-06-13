package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Sensordata;

public interface SensordataRepository extends CrudRepository<Sensordata, Integer> {

	public List<Sensordata> findDataByRobotModel(String robotModel);
	
}
