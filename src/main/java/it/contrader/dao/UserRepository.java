package it.contrader.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.model.User;

import java.util.List;

import javax.transaction.Transactional;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findUserByUserUserAndUserPass(String username,String password);
	public List<User> findAllByUserUser(String username);
	
	/*@Transactional
		@Query(value="SELECT * FROM user WHERE user_user=?1 AND user_pass=?2", nativeQuery = true)
	public User findUserByUsernameAndPassword(@RequestParam("username")String username,@RequestParam("password")String password);
	
	@Transactional
	@Query(value="SELECT * FROM user WHERE user_type =?1",nativeQuery =true)
	public List<User> findAllByType(@RequestParam("doctor")String userType);*/
	
}
