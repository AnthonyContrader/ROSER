package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;
import it.contrader.model.User.Usertype;


/**
 * Estende CrudRepository ed eredita tutti i metodi di CRUD. 
 * Definisce il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 *
 * @see CrudRepository
 *
 */
@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long>{

	public List<User> findAllUserByUsertype(Usertype userType);
	User findByUsernameAndPassword(String username, String password);
	
}
