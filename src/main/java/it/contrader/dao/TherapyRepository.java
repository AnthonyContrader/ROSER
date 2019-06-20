package it.contrader.dao;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Therapy;


@Repository
@Transactional
public interface TherapyRepository extends CrudRepository<Therapy, Long>{

	Therapy findById(int id);
	
}
