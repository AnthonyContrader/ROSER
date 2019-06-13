package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Robot;

public interface RobotRepository extends CrudRepository<Robot, Integer> {

	public Robot findRobotByRobotModel(String robotModel);
	/*public User findUserByUserUserAndUserPass(String username,String password);
	public List<User> findAllByUserUser(String username);*/
	
	/*@Transactional
		@Query(value="SELECT * FROM user WHERE user_user=?1 AND user_pass=?2", nativeQuery = true)
	public User findUserByUsernameAndPassword(@RequestParam("username")String username,@RequestParam("password")String password);
	
	@Transactional
	@Query(value="SELECT * FROM user WHERE user_type =?1",nativeQuery =true)
	public List<User> findAllByType(@RequestParam("doctor")String userType);*/
	
}